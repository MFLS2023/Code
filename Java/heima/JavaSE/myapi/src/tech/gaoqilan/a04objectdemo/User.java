package tech.gaoqilan.a04objectdemo;


import java.util.StringJoiner;

public class User implements Cloneable{
    private int id; // 游戏角色
    private String username; // 用户名
    private String password; // 密码
    private String path; // 头像图片
    private int[] data; // 游戏进度

    public User() { }

    public User(int id, String username, String password, String path, int[] data) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.path = path;
        this.data = data;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getPath() { return path; }

    public void setPath(String path) { this.path = path; }

    public int[] getData() { return data; }

    public void setData(int[] data) { this.data = data; }

    public String arrToString() {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < data.length; i++) {
            sj.add(data[i] + "");
        }
        return sj.toString();
    }

    @Override
    public String toString() {
        return "角色编号为: " + id + ", 用户名: " + username + ", 密码: " + password + ", 游戏图片: " + path + ", 进度: " + arrToString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //调用父类中的clone方法
        //相当于让Java帮我们克隆一个对象，并把克隆之后的对象返回出去
        //return super.clone();
        // 先把被克隆对象中的数组获取出来
        int[] data = this.data;
        // 创建新的数组
        int[] newData = new int[data.length];
        // 拷贝数组中的数据
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        // 调用父类中的方法克隆对象
        User u = (User) super.clone();
        // 因为父类中的克隆方法是浅克隆，直接克隆出来的对象中的数组地址相同
        u.data = newData;
        return u;

    }
}
