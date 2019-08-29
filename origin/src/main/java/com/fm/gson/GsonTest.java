package com.fm.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import org.joda.time.DateTime;

import java.lang.reflect.Type;

/**
 * @author footmanff on 2018/12/1.
 */
public class GsonTest {

    public static void main(String[] args) {
        GsonBuilder gsonbuilder = new GsonBuilder();
        gsonbuilder.registerTypeAdapter(String.class, new DateTimeDeserializer());
        Gson gson = gsonbuilder.create();

        Model model = new Model();
        model.setValue("hello");
        String json = gson.toJson(model);
        System.out.println(json);

        model = gson.fromJson(json, Model.class);
    }

    private static class DateTimeDeserializer implements JsonDeserializer<String> {

        @Override
        public String deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return json.getAsString() + "||";
        }
    }

    static class Model {
        private String value;

        public String getValue() {
            return value;
        }

        public Model setValue(String value) {
            this.value = value;
            return this;
        }
    }

}
