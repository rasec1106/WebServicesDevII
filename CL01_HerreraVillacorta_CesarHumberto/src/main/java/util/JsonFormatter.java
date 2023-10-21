package util;

import org.json.simple.JSONObject;

public class JsonFormatter {

    public static String jsonToString(JSONObject jsonObject) {
    	//return jsonObject.toString();
    	return JsonFormatter.formatJSONObject(jsonObject, 0);
    }
    
	private static String formatJSONObject(JSONObject jsonObject, int indentLevel) {
        StringBuilder formattedJson = new StringBuilder("{\n");

        boolean firstEntry = true;
        for (Object key : jsonObject.keySet()) {
            if (!firstEntry) {
                formattedJson.append(",\n");
            }

            formattedJson.append(getIndent(indentLevel + 1))
                    .append("\"")
                    .append(key)
                    .append("\": ");

            Object value = jsonObject.get(key);
            if (value instanceof JSONObject) {
                formattedJson.append(formatJSONObject((JSONObject) value, indentLevel + 1));
            } else if(value instanceof String) {
                formattedJson.append("\""+JSONObject.escape(value.toString())+"\"");
            } else {
                formattedJson.append(JSONObject.escape(value.toString()));
            }

            firstEntry = false;
        }

        formattedJson.append("\n").append(getIndent(indentLevel)).append("}");

        return formattedJson.toString();
    }
    
    private static String getIndent(int indentLevel) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < indentLevel; i++) {
            indent.append("    "); // Four spaces per level
        }
        return indent.toString();
    }
}
