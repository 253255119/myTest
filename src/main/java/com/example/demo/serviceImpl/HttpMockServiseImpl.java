package com.example.demo.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.HttpMockReq;
import com.example.demo.mapper.MockConfigurationMapper;
import com.example.demo.mapper.MockResponseMapper;
import com.example.demo.models.MockConfiguration;
import com.example.demo.models.MockResponse;
import com.example.demo.service.HttpMockServise;
import com.example.demo.utils.HttpServletRequestUtil;
import com.example.demo.utils.MybaitsUtil;
import com.example.demo.utils.StringConversion;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 25325
 * @Description: http mock
 * @DateTime: 2021-09-30 22:46
 **/
@Slf4j
@Service
public class HttpMockServiseImpl implements HttpMockServise {

    @Override
    public Object httpMock(HttpMockReq req) {
//        SqlSession sqlSession = MybaitsUtil.createSqlSession("2");
//        log.info("this request.get type is : {} ;",req.getRequest().getContentType());
//        MockConfigurationMapper configurationMapper=sqlSession.getMapper(MockConfigurationMapper.class);
//        MockResponseMapper mockResponseMapper=sqlSession.getMapper(MockResponseMapper.class);
//        MockConfiguration mockConfiguration=configurationMapper.selectByMockUrl(req.getRequest().getRequestURI());
//        log.info("this mockConfiguration   is  :   {}",mockConfiguration);
//        List<MockResponse> mockResponseList=mockResponseMapper.selectByMockId(mockConfiguration.getId());
//        log.info("this List<MockResponse> mockResponseList is :  {}",mockResponseList);
//
//        if (mockResponseList.size()<0){
//            return new  ResponseEntity(null,null,HttpStatus.resolve(404));
//        }
//        if (mockResponseMapper.selectByMockIdAndNotCheck(mockConfiguration.getId()).size()>0){
//            int i=0;
//            return new ResponseEntity(mockResponseMapper.selectByMockIdAndNotCheck(mockConfiguration.getId()).get(i).getResBody(),
//                    (MultiValueMap)  JSON.parseObject(mockResponseMapper.selectByMockIdAndNotCheck(mockConfiguration.getId()).get(i).getResHeader()),
//                            HttpStatus.resolve(mockResponseMapper.selectByMockIdAndNotCheck(mockConfiguration.getId()).get(i).getHttpCode())
//            );
//        }
//        if (mockResponseMapper.selectByMockIdAndCheck(mockConfiguration.getId()).size()>0){
//            return null;
//        }
//
//        MybaitsUtil.closeSqlSession(sqlSession);
//        return new ResponseEntity("asdasda", null, HttpStatus.resolve(400));
        return getResponseEntity(req);
    }

    public static ResponseEntity getResponseEntity(HttpMockReq req) {
        SqlSession sqlSession = MybaitsUtil.createSqlSession("2");
        MockConfigurationMapper configurationMapper = sqlSession.getMapper(MockConfigurationMapper.class);
        MockResponseMapper mockResponseMapper = sqlSession.getMapper(MockResponseMapper.class);
        MockConfiguration cc = configurationMapper.selectByMockUrl(req.getRequest().getRequestURI());
        List<MockResponse> notCheckList = mockResponseMapper.selectByMockIdAndNotCheck(cc.getId());
        log.info("请求url is ：{};", req.getRequest().getRequestURI());
        String body = null;
        //判断是否有有效响应结果
        if (cc == null) {
            MybaitsUtil.closeSqlSession(sqlSession);
            log.info("该 url没有配置有效的响应结果");
            return new ResponseEntity(null, null, HttpStatus.resolve(404));
        }
        //判断是否需要提取请求头
        Map reqGetMap = new HashMap();
        List reqGet = new ArrayList();
        if (cc.getGetReqType() == 1) {
            reqGet = StringConversion.stringToList(cc.getGetReqheader());
            for (int i = 0; i < reqGet.size(); i++) {
                reqGetMap.put(reqGet.get(i), req.getHeadermap().get(reqGet.get(i)));
                log.info("循环获取请求头数据中。。。，当前获取 {} 字段，值为：{};", reqGet.get(i), req.getHeadermap().get(reqGet.get(i)));
            }
            log.info("配置只获取请求头，获取字段：{}；获取结果为：{};", reqGet, reqGetMap);
        } else if (cc.getGetReqType() == 2) {

            JSONObject bj = null;
            if (req.getRequest().getContentType().equals("application/json")) {
                bj = HttpServletRequestUtil.requestBodyJS(req.getRequest());
            }
            for (int i = 0; i < reqGet.size(); i++) {
                reqGetMap.put(reqGet.get(i), req.getParamMap().get(reqGet.get(i)));
                log.info("循环获取请求体getParamMap数据中。。。，当前获取 {} 字段，值为：{};", reqGet.get(i), req.getParamMap().get(reqGet.get(i)));
                //如果请求体是raw json格式
                if (req.getRequest().getContentType().equals("application/json")) {
                    reqGetMap.put(reqGet.get(i), bj.get(reqGet.get(i)));
                    log.info("当前请求为application/json格式， 循环获取请求体raw数据中。。。，当前获取 {} 字段，值为：{};", reqGet.get(i), bj.get(reqGet.get(i)));
                }
            }
            log.info("配置只获取请求体，获取字段：{}；获取结果为：{};", reqGet, reqGetMap);
        } else if (cc.getGetReqType() == 3) {
            reqGet = StringConversion.stringToList(cc.getGetReqbody() + "," + cc.getGetReqheader());
            for (int i = 0; i < reqGet.size(); i++) {
                reqGetMap.put(reqGet.get(i), req.getHeadermap().get(reqGet.get(i)));
                log.info("循环获取请求头数据中。。。，当前获取 {} 字段，值为：{};", reqGet.get(i), req.getHeadermap().get(reqGet.get(i)));
            }
            JSONObject bj = null;
            if (req.getRequest().getContentType().equals("application/json")) {
                bj = HttpServletRequestUtil.requestBodyJS(req.getRequest());
            }
            for (int i = 0; i < reqGet.size(); i++) {

                reqGetMap.put(reqGet.get(i), req.getParamMap().get(reqGet.get(i)));
                log.info("循环获取请求体getParamMap数据中。。。，当前获取 {} 字段，值为：{};", reqGet.get(i), req.getParamMap().get(reqGet.get(i)));
                //如果请求体是raw json格式
                if (req.getRequest().getContentType().equals("application/json")) {
                    reqGetMap.put(reqGet.get(i), bj.get(reqGet.get(i)));
                    log.info("当前请求为application/json格式， 循环获取请求体raw数据中。。。，当前获取 {} 字段，值为：{};", reqGet.get(i), bj.get(reqGet.get(i)));
                }
            }
            log.info("配置获取请求头和请求体，获取字段：{}；获取结果为：{};", reqGet, reqGetMap);
        }
        //判断是否有结果校验
        if (notCheckList.size() > 0) {
            log.info("该url存在未配置任何规则的有效响应，默认返回第一条:{}", notCheckList.get(0));
            if (notCheckList.get(0).getIfUseVariables() == 1) { //判断是否使用变量
                body = varuiableToVl(notCheckList.get(0).getResBody(), reqGetMap);
                log.info("响应体使用变量，原始报文：{}，替换变量后报文：{}", notCheckList.get(0).getResBody(), body);
            } else {
                body = notCheckList.get(0).getResBody();
                log.info("报文不使用变量，直接返回body：{}；", body);
            }
            MybaitsUtil.closeSqlSession(sqlSession);
            return new ResponseEntity(body, null, HttpStatus.OK);
        } else {
            List<MockResponse> cck = mockResponseMapper.selectByMockIdAndCheck(cc.getId());
            if (cck.size() > 0) {
                log.info("匹配响应结果中。。。。，请求获取：{}，检验点：{}", reqGetMap, cck);
                int k = ifReturnBody(reqGetMap, mockAndChek(cck));
                log.info("匹配成功，id：{}；", k);
                if (mockResponseMapper.selectByPrimaryKey(k).getIfUseVariables() == 1) {

                    body = varuiableToVl(mockResponseMapper.selectByPrimaryKey(k).getResBody(), reqGetMap);
                    log.info("响应体使用变量，原始报文：{}，替换变量后报文：{}", mockResponseMapper.selectByPrimaryKey(k).getResBody(), body);
                } else {
                    body = mockResponseMapper.selectByPrimaryKey(k).getResBody();
                    log.info("报文不使用变量，直接返回body：{}；", body);
                }
                k = mockResponseMapper.selectByPrimaryKey(k).getHttpCode();
                MybaitsUtil.closeSqlSession(sqlSession);
                return new ResponseEntity(body, null, HttpStatus.resolve(k));
            }
        }
        MybaitsUtil.closeSqlSession(sqlSession);
        return new ResponseEntity(null, null, null);
    }

    public static String varuiableToVl(String varInP, Map map) {  //变量名替换成实际值
        int flag = 0;
        String var = varInP;
        String str = "$";
        List<Integer> list = new ArrayList();
        while (var.indexOf(str) != -1) {
            //截取包含自身在内的前边部分
            String aa = var.substring(0, var.indexOf(str) + str.length());
            flag = flag + aa.length();
            list.add(flag - str.length());
            var = var.substring(var.indexOf(str) + str.length());
        }
        log.info("list is :{};{};", list, varInP.length());
        for (int i = 0; i < list.size(); i += 2) {
            String key = varInP.substring(list.get(i) + 1, list.get(i + 1));
            log.info("varInP.substring(list.get(i),list.get(i+1)){}", varInP.substring(list.get(i) + 1, list.get(i + 1)));
            log.info("nnnnnnnnnnnnnnnn{},{}", map.get(key), map);
            String old = varInP.substring(list.get(i) + 1, list.get(i + 1));
            String news = (String) map.get(key);
            if (old.length() != news.length()) {
                List list1 = new ArrayList();
                for (int j = 0; j < list.size(); j++) {
                    list1.add(list.get(j) + (news.length() - old.length()));
                }
                list = list1;
            }
            varInP = varInP.replaceAll(old, news);
        }
        return varInP.replaceAll("\\$", "");
    }

    public static Map chekResBody(Integer id, MockResponseMapper m) {  //提取最终的响应结果
        log.info("chekResBody(Integer id,MockResponseMapper m) : id={};  ", id);
        if (m.selectByPrimaryKey(id) != null) {
            Map map = new HashMap();
            map.put("body", m.selectByPrimaryKey(id).getResBody());
            map.put("header", JSON.parseObject(m.selectByPrimaryKey(id).getResHeader()));
            map.put("httpCode", m.selectByPrimaryKey(id).getHttpCode());
            log.info("chekResBody(Integer id,MockResponseMapper m) res :  return map={};  ", map);
            return map;
        }
        return null;
    }

    public static Map reqbodyMap(HttpMockReq req, List list) { //获取请求内容
        Map map = new HashMap();
        log.info("reqbodyMap(HttpMockReq req,List list) : req list={}", list);
        for (int i = 0; i < list.size(); i++) {
            if (req.getRequest().getContentType().equals("application/json")) {
                map.put(list.get(i), HttpServletRequestUtil.requestBodyJS(req.getRequest()).get(list.get(i)));
                log.info("请求体为json格式，获取请求体中需要提取字段值");
            }
            if (req.getParamMap() != null) {
                map.put(list.get(i), req.getParamMap().get(list.get(i)));
                log.info("请求体包含param或请求是 from-xxxx格式，获取param中需要提取的字段");
            }
            if (req.getHeadermap() != null) {
                map.put(list.get(i), req.getHeadermap().get(list.get(i)));
                log.info("获取请求头所需要提取的字段");
            }
        }
        log.info("配置提取字段最终获取到的值为：reqbodyMap={}", map);
        return map;
    }

    public static Map mockAndChek(List<MockResponse> mockResponseList) { //获取设置响应的结果
        log.info("mockAndChek(List<MockResponse> mockResponseList) res is: mockResponseList={}", mockResponseList);
        if (mockResponseList.size() < 1) {
            return null;
        }
        Map<Integer, JSONObject> map = new HashMap();
        for (int i = 0; i < mockResponseList.size(); i++) {
            if (mockResponseList.get(i).getIfCheck() != 1 || StringUtils.isEmpty(mockResponseList.get(i).getResCondition())) {
                log.info("该条记录未配置检验响应结果，或为配置结果校验规则，mockResponse is {}", mockResponseList.get(i));
                continue;
            }
            map.put(mockResponseList.get(i).getId(), JSON.parseObject(mockResponseList.get(i).getResCondition()));
        }
        log.info("已配置响应规则的查询结果如下：mockAndChek>>{}", map);
        return map;
    }

    public static Integer ifReturnBody(Map map, Map<Integer, JSONObject> map1) {  //匹配结果
        log.info("ifReturnBody(Map map ,Map<Integer ,JSONObject> map1)>>> 需要检验的mockAndChekMap>>{};提取到的请求map>>{};", map1, map);
        for (Integer K : map1.keySet()) {
            int i = 0;
            for (Object k : map1.get(K).keySet()) {
                if (map1.get(K).get(k).equals(map.get(k))) {
                    i++;
                    if (i == map1.get(K).size()) {
                        log.info("IFreturnBody is true ,ID is : {};", K);
                        return K;
                    }
                } else {
                    continue;
                }

            }
        }
        return null;
    }

    public static void main(String[] args) {
//        SqlSession sqlSession = MybaitsUtil.createSqlSession("2");
//        MockConfigurationMapper configurationMapper=sqlSession.getMapper(MockConfigurationMapper.class);
//        MockResponseMapper mockResponseMapper=sqlSession.getMapper(MockResponseMapper.class);
//        MockConfiguration cc= configurationMapper.selectByMockUrl("ssss");
//        System.out.println("sssssssssssss>>>>>>>>>>"+cc);
//        System.out.println("ccccccccc>>>>>>>>>>>>>>"+cc.getMockUrl());
//        MybaitsUtil.closeSqlSession(sqlSession);
        String aa = "{\"res1\":\"123\",\"res2\":\"234\",\"res3\":\"$var3$\",\"res4\":\"$var2$\"}";
        Map map = new HashMap();
        map.put("var3", "vvvwqwe1v");
        map.put("var2", "cccc");
        System.out.println(varuiableToVl(aa, map));
        System.out.println(aa.substring(3, 5));
        System.out.println(aa.replaceAll(aa.substring(3, 5), map.get("var3").toString()).replaceAll("\\$", ""));

    }
}
