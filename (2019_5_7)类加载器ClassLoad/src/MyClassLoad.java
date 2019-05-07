import java.io.*;

public class MyClassLoad extends ClassLoader{
    private String classPath;

    public MyClassLoad(String classPath){
        this.classPath = classPath;
    }
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte [] classData = getData(name);
            if (classData == null){}
            else{
                return defineClass(name,classData,0,classData.length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }

    private byte[] getData(String className) throws IOException {
        InputStream in = null;
        ByteArrayOutputStream out = null;
        try{
            String path = classPath+ File.separatorChar+
                    className.replace('.',File.separatorChar)+".class";
            in = new FileInputStream(path);
            out = new ByteArrayOutputStream();
            byte [] buffer = new byte[2048];
            int len = 0;
            while ((len = in.read(buffer))!=-1){
                out.write(buffer,0,len);
            }
            return out.toByteArray();
        }catch (Exception e){
            return null;
        }finally {
            if (in != null&&out!=null){
                in.close();
                out.close();
            }
        }
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        try {
            byte [] classData = getData(name);
            if (classData == null){
                return super.loadClass(name);
            }
            return defineClass(name,classData,0,classData.length);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
