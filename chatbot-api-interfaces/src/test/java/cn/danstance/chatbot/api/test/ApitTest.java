package cn.danstance.chatbot.api.test;

import com.github.dockerjava.transport.DockerHttpClient;
import io.github.bonigarcia.wdm.online.HttpClient;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;

/**
 * @ClassName ApitTest
 * @Description TODO
 * @date 2024/3/15 0:08
 * @Version 1.0
 */
public class ApitTest {
    @Test
    public void query_unanswered_quest() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/28888825842221/topics?scope=unanswered_questions&count=20");
        get.addHeader("cookie","zsxq_access_token=AEA5D2C7-EB1C-0D00-A0CC-2115B2BF0FC7_6015B8402E791B23; abtest_env=product; zsxqsessionid=5e4b9dada41c48fb51fd4384f1a40560; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22184511454218582%22%2C%22first_id%22%3A%2218dd1315ae52f6-0de28086d905448-4c657b58-1327104-18dd1315ae6162%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThkZDEzMTVhZTUyZjYtMGRlMjgwODZkOTA1NDQ4LTRjNjU3YjU4LTEzMjcxMDQtMThkZDEzMTVhZTYxNjIiLCIkaWRlbnRpdHlfbG9naW5faWQiOiIxODQ1MTE0NTQyMTg1ODIifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22184511454218582%22%7D%2C%22%24device_id%22%3A%2218dd1315ae52f6-0de28086d905448-4c657b58-1327104-18dd1315ae6162%22%7D");
        get.addHeader("Content-Type","application/json;charset=utf8");

        CloseableHttpResponse response = httpClient.execute(get);
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }

    }

    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/4844851541512118/answer");

        post.addHeader("cookie", "zsxq_access_token=AEA5D2C7-EB1C-0D00-A0CC-2115B2BF0FC7_6015B8402E791B23; abtest_env=product; zsxqsessionid=5e4b9dada41c48fb51fd4384f1a40560; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22184511454218582%22%2C%22first_id%22%3A%2218dd1315ae52f6-0de28086d905448-4c657b58-1327104-18dd1315ae6162%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThkZDEzMTVhZTUyZjYtMGRlMjgwODZkOTA1NDQ4LTRjNjU3YjU4LTEzMjcxMDQtMThkZDEzMTVhZTYxNjIiLCIkaWRlbnRpdHlfbG9naW5faWQiOiIxODQ1MTE0NTQyMTg1ODIifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22184511454218582%22%7D%2C%22%24device_id%22%3A%2218dd1315ae52f6-0de28086d905448-4c657b58-1327104-18dd1315ae6162%22%7D");
        post.addHeader("Content-Type", "application/json;charset=utf8");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"666666\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"silenced\": false\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("test-json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse  response =  httpClient.execute(post);

        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }

    }

}
