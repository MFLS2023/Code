#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <openssl/md5.h>  // ��Ҫ��װOpenSSL��

#define MAX_USERS 1000    // ����û�����
#define USER_FILE "user.txt"

typedef struct {
    char account[20];
    char password[33];    // MD5���ܺ�����볤��Ϊ32�ַ�����1��Ž�����
    char phone[15];
} User;

User users[MAX_USERS];
int user_count = 0;
int logged_in_index = -1; // ��ǰ��¼�û�������

// ��������
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
        printf("\n===== ���Ŷ����û�����ϵͳ =====\n");
        printf("1. �鿴�����û���Ϣ\n");
        printf("2. �û�ע��\n");
        printf("3. �û���¼\n");
        printf("4. �鿴������Ϣ\n");
        printf("5. �޸ĸ�����Ϣ\n");
        printf("6. ע��������Ϣ\n");
        printf("7. �˳�ϵͳ\n");
        printf("��ѡ���ܣ�1-7����");
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
                printf("��������������ѡ��\n");
        }
    }
    return 0;
}

// ��ȡ�û���Ϣ
void read_users() {
    FILE *fp = fopen(USER_FILE, "r");
    if (fp == NULL) {
        printf("�޷����û��ļ�����ʼ��Ϊ���б�\n");
        return;
    }

    while (fscanf(fp, "%s %s %s", users[user_count].account,
                  users[user_count].password, users[user_count].phone) != EOF) {
        user_count++;
    }
    fclose(fp);
}

// д���û���Ϣ
void write_users() {
    FILE *fp = fopen(USER_FILE, "w");
    if (fp == NULL) {
        printf("�޷�д���û��ļ���\n");
        return;
    }
    for (int i = 0; i < user_count; i++) {
        fprintf(fp, "%s %s %s\n", users[i].account,
                users[i].password, users[i].phone);
    }
    fclose(fp);
}

// �鿴�����û���Ϣ
void view_all_users() {
    printf("\n��ǰ�����û���Ϣ��\n");
    printf("�˺�\t\t���루MD5���ܣ�\t\t�ֻ���\n");
    for (int i = 0; i < user_count; i++) {
        printf("%s\t%s\t%s\n", users[i].account,
               users[i].password, users[i].phone);
    }
}

// ���ֲ����û�
int binary_search(char *account) {
    int left = 0, right = user_count - 1;
    while (left <= right) {
        int mid = (left + right) / 2;
        int cmp = strcmp(users[mid].account, account);
        if (cmp == 0) {
            return mid; // �ҵ��û�
        } else if (cmp < 0) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return -1; // δ�ҵ�
}

// �û�ע��
void user_register() {
    User new_user;
    printf("�������˺ţ�");
    scanf("%s", new_user.account);

    if (binary_search(new_user.account) != -1) {
        printf("ע��ʧ�ܣ��û��Ѵ��ڡ�\n");
        return;
    }

    printf("���������룺");
    scanf("%s", new_user.password);
    printf("�������ֻ��ţ�");
    scanf("%s", new_user.phone);

    // �򵥵ķǷ������жϣ����Ը�����Ҫ����
    if (strlen(new_user.account) == 0 || strlen(new_user.password) == 0 ||
        strlen(new_user.phone) == 0) {
        printf("ע��ʧ�ܣ�������Ϣ����Ϊ�ա�\n");
        return;
    }

    // �������
    char encrypted_password[33];
    md5_encrypt(new_user.password, encrypted_password);
    strcpy(new_user.password, encrypted_password);

    // ���뵽˳�����
    int i = user_count - 1;
    while (i >= 0 && strcmp(users[i].account, new_user.account) > 0) {
        users[i + 1] = users[i];
        i--;
    }
    users[i + 1] = new_user;
    user_count++;

    write_users();
    printf("ע��ɹ���\n");
}

// �û���¼
void user_login() {
    char account[20], password[33];
    printf("�������˺ţ�");
    scanf("%s", account);
    printf("���������룺");
    scanf("%s", password);

    int index = binary_search(account);
    if (index != -1) {
        // ������ܺ�ȶ�
        char encrypted_password[33];
        md5_encrypt(password, encrypted_password);
        if (strcmp(users[index].password, encrypted_password) == 0) {
            logged_in_index = index;
            printf("��¼�ɹ���\n");
            return;
        }
    }
    printf("��¼ʧ�ܣ�\n");
}

// �鿴������Ϣ
void view_personal_info() {
    if (logged_in_index == -1) {
        printf("���ȵ�¼��\n");
        return;
    }
    printf("�˺ţ�%s\n", users[logged_in_index].account);
    printf("�ֻ��ţ�%s\n", users[logged_in_index].phone);
}

// �޸ĸ�����Ϣ
void modify_personal_info() {
    if (logged_in_index == -1) {
        printf("���ȵ�¼��\n");
        return;
    }
    printf("�����������룺");
    scanf("%s", users[logged_in_index].password);
    printf("���������ֻ��ţ�");
    scanf("%s", users[logged_in_index].phone);

    // �������
    char encrypted_password[33];
    md5_encrypt(users[logged_in_index].password, encrypted_password);
    strcpy(users[logged_in_index].password, encrypted_password);

    write_users();
    printf("��Ϣ�޸ĳɹ���\n");
}

// ע��������Ϣ
void delete_personal_info() {
    if (logged_in_index == -1) {
        printf("���ȵ�¼��\n");
        return;
    }
    for (int i = logged_in_index; i < user_count - 1; i++) {
        users[i] = users[i + 1];
    }
    user_count--;
    logged_in_index = -1;
    write_users();
    printf("�˺���ע����\n");
}

// ���������û�����
void encrypt_passwords() {
    for (int i = 0; i < user_count; i++) {
        char encrypted_password[33];
        md5_encrypt(users[i].password, encrypted_password);
        strcpy(users[i].password, encrypted_password);
    }
}

// MD5���ܺ���
void md5_encrypt(char *input, char *output) {
    unsigned char digest[16];
    MD5((unsigned char*)input, strlen(input), digest);
    for (int i = 0; i < 16; i++) {
        sprintf(&(output[i * 2]), "%02x", (unsigned int)digest[i]);
    }
    output[32] = '\0';
}
