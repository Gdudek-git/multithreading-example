package utils;


public class GetResourcePath {

    public static String getResourcePath(String path)
    {
        return GetResourcePath.class.getResource(path).toString();
    }
}
