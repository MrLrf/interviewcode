/**
 * 类的描述
 *
 * @Author lirf
 * @Date 2018/4/17 16:14
 */
public class ClassArrayTest {

    public static void main(String[] args) {
        User[] users = new User[3];

        users[0] = new User("1", 20, "this");
        users[1] = new User("2", 21, "there");

        System.out.println(users[0].getName());
        System.out.println(users[1].getName());
    }

}
