package sample.Tool.GetAndPost;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.util.URIUtil;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * @autHor LHYJTZ
 * @data 2021年04月23日 13:51
 */
public class GetAndPost {
    public String cs(String name) {
        if (name != null) {
            System.out.println(name);
            return name;
        } else {
            System.out.println("null");
            return "null";
        }
    }

    public String doGet(String url, String queryString, String charset, boolean pretty) {
        StringBuffer response = new StringBuffer();
        HttpClient client = new HttpClient();
        HttpMethod method = new GetMethod(url);
        try {
            if (StringUtils.isNotBlank(queryString))
                method.setQueryString(URIUtil.encodeQuery(queryString));
            client.executeMethod(method);
            getPostAll(charset, pretty, response, method);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response.toString();
    }

    public String doPost(String url, Map<String, String> params, String charset, boolean pretty) {
        StringBuffer response = new StringBuffer();
        HttpClient httpClient = new HttpClient();
        HttpMethod method = new PostMethod(url);
        if (params != null) {
            HttpMethodParams httpMethodParams = new HttpMethodParams();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                httpMethodParams.setParameter(entry.getKey(), entry.getValue());
            }
            method.setParams(httpMethodParams);
        }
        try {
            httpClient.executeMethod(method);
            getPostAll(charset, pretty, response, method);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response.toString();
    }

    private void getPostAll(String charset, boolean pretty, StringBuffer response, HttpMethod method) throws IOException {
        if (method.getStatusCode() == HttpStatus.SC_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream(), charset));
            String line;
            while ((line = reader.readLine()) != null) {
                if (pretty)
                    response.append(line).append(System.getProperty("line.separator"));
                else
                    response.append(line);
            }
            reader.close();
        }
    }
}
