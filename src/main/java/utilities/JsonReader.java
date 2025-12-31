package utilities;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;

public final class JsonReader {

    public static <T> T readJsonAsPojo(String filepath, String objectKey, Class<T> clazz) {
        try {
            final String content = new String(Files.readAllBytes(Paths.get(filepath)));
            final JSONObject json = new JSONObject(content);

            return new Gson().fromJson(json.getJSONObject(objectKey).toString(), clazz);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse JSON as POJO", e);
        }
    }
}