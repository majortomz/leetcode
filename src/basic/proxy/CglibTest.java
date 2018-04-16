package basic.proxy;

/**
 * Created by zjw on 2018/03/31 10:56
 * Description:
 */
public class CglibTest {

    public static void main(String[] args) {
        BookFacadeCglib cglib = new BookFacadeCglib();
        BookFacadeImpl bookFacade = (BookFacadeImpl)cglib.getInstance(new BookFacadeImpl());
        bookFacade.addBook();
    }

}
