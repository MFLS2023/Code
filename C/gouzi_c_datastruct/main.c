#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <openssl/md5.h>  // 需要安装OpenSSL库

#define MAX_USERS 1000    // 最大用户数量
#define USER_FILE "user.txt"

typedef struct {
    char account[20];
    char password[33];    // MD5加密后的密码长度为32字符，加1存放结束符
    char phone[15];
} User;

User users[MAX_USERS];
int user_count = 0;
int logged_in_index = -1; // 当前登录用户的索引

// 函数声明
void read_users();
void write_users();
void view_all_users();
int binary_search(char *account);
void user_register();
void user_login();
void view_personal_info();
void modify_personal_info();
void delete_personal_info();
void encrypt_passwords();
void md5_encrypt(char *input, char *output);

int main() {
    int choice;

    read_users();
    encrypt_passwords();

    while (1) {
        printf("\n===== 美团订餐用户管理系统 =====\n");
        printf("1. 查看所有用户信息\n");
        printf("2. 用户注册\n");
        printf("3. 用户登录\n");
        printf("4. 查看个人信息\n");
        printf("5. 修改个人信息\n");
        printf("6. 注销个人信息\n");
        printf("7. 退出系统\n");
        printf("请选择功能（1-7）：");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                view_all_users();
                break;
            case 2:
                user_register();
                break;
            case 3:
                user_login();
                break;
            case 4:
                view_personal_info();
                break;
            case 5:
                modify_personal_info();
                break;
            case 6:
                delete_personal_info();
                break;
            case 7:
                write_users();
                exit(0);
            default:
                printf("输入有误，请重新选择！\n");
        }
    }
    return 0;
}

// 读取用户信息
void read_users() {
    FILE *fp = fopen(USER_FILE, "r");
    if (fp == NULL) {
        printf("无法打开用户文件，初始化为空列表。\n");
        return;
    }

    while (fscanf(fp, "%s %s %s", users[user_count].account,
                  users[user_count].password, users[user_count].phone) != EOF) {
        user_count++;
    }
    fclose(fp);
}

// 写入用户信息
void write_users() {
    FILE *fp = fopen(USER_FILE, "w");
    if (fp == NULL) {
        printf("无法写入用户文件！\n");
        return;
    }
    for (int i = 0; i < user_count; i++) {
        fprintf(fp, "%s %s %s\n", users[i].account,
                users[i].password, users[i].phone);
    }
    fclose(fp);
}

// 查看所有用户信息
void view_all_users() {
    printf("\n当前所有用户信息：\n");
    printf("账号\t\t密码（MD5加密）\t\t手机号\n");
    for (int i = 0; i < user_count; i++) {
        printf("%s\t%s\t%s\n", users[i].account,
               users[i].password, users[i].phone);
    }
}

// 二分查找用户
int binary_search(char *account) {
    int left = 0, right = user_count - 1;
    while (left <= right) {
        int mid = (left + right) / 2;
        int cmp = strcmp(users[mid].account, account);
        if (cmp == 0) {
            return mid; // 找到用户
        } else if (cmp < 0) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return -1; // 未找到
}

// 用户注册
void user_register() {
    User new_user;
    printf("请输入账号：");
    scanf("%s", new_user.account);

    if (binary_search(new_user.account) != -1) {
        printf("注册失败！用户已存在。\n");
        return;
    }

    printf("请输入密码：");
    scanf("%s", new_user.password);
    printf("请输入手机号：");
    scanf("%s", new_user.phone);

    // 简单的非法输入判断，可以根据需要完善
    if (strlen(new_user.account) == 0 || strlen(new_user.password) == 0 ||
        strlen(new_user.phone) == 0) {
        printf("注册失败！输入信息不能为空。\n");
        return;
    }

    // 密码加密
    char encrypted_password[33];
    md5_encrypt(new_user.password, encrypted_password);
    strcpy(new_user.password, encrypted_password);

    // 插入到顺序表中
    int i = user_count - 1;
    while (i >= 0 && strcmp(users[i].account, new_user.account) > 0) {
        users[i + 1] = users[i];
        i--;
    }
    users[i + 1] = new_user;
    user_count++;

    write_users();
    printf("注册成功！\n");
}

// 用户登录
void user_login() {
    char account[20], password[33];
    printf("请输入账号：");
    scanf("%s", account);
    printf("请输入密码：");
    scanf("%s", password);

    int index = binary_search(account);
    if (index != -1) {
        // 密码加密后比对
        char encrypted_password[33];
        md5_encrypt(password, encrypted_password);
        if (strcmp(users[index].password, encrypted_password) == 0) {
            logged_in_index = index;
            printf("登录成功！\n");
            return;
        }
    }
    printf("登录失败！\n");
}

// 查看个人信息
void view_personal_info() {
    if (logged_in_index == -1) {
        printf("请先登录！\n");
        return;
    }
    printf("账号：%s\n", users[logged_in_index].account);
    printf("手机号：%s\n", users[logged_in_index].phone);
}

// 修改个人信息
void modify_personal_info() {
    if (logged_in_index == -1) {
        printf("请先登录！\n");
        return;
    }
    printf("请输入新密码：");
    scanf("%s", users[logged_in_index].password);
    printf("请输入新手机号：");
    scanf("%s", users[logged_in_index].phone);

    // 密码加密
    char encrypted_password[33];
    md5_encrypt(users[logged_in_index].password, encrypted_password);
    strcpy(users[logged_in_index].password, encrypted_password);

    write_users();
    printf("信息修改成功！\n");
}

// 注销个人信息
void delete_personal_info() {
    if (logged_in_index == -1) {
        printf("请先登录！\n");
        return;
    }
    for (int i = logged_in_index; i < user_count - 1; i++) {
        users[i] = users[i + 1];
    }
    user_count--;
    logged_in_index = -1;
    write_users();
    printf("账号已注销！\n");
}

// 加密所有用户密码
void encrypt_passwords() {
    for (int i = 0; i < user_count; i++) {
        char encrypted_password[33];
        md5_encrypt(users[i].password, encrypted_password);
        strcpy(users[i].password, encrypted_password);
    }
}

// MD5加密函数
void md5_encrypt(char *input, char *output) {
    unsigned char digest[16];
    MD5((unsigned char*)input, strlen(input), digest);
    for (int i = 0; i < 16; i++) {
        sprintf(&(output[i * 2]), "%02x", (unsigned int)digest[i]);
    }
    output[32] = '\0';
}
