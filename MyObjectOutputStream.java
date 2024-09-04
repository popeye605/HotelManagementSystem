
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.IOException;


public class MyObjectOutputStream extends ObjectOutputStream{
    MyObjectOutputStream() throws IOException{
        super();
    }
    MyObjectOutputStream(OutputStream o) throws IOException{
        super(o);
    }
    public void writeStreamHeader(){}
}
