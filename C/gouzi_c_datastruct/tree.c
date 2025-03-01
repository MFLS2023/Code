#include <stdio.h>
#include <limits.h> // ʹ��INT_MAX����ʾ�����
#include <stdbool.h>

#define MAX 10        // ��������
#define INF INT_MAX   // ��ʾ������Ȩֵ

// �����ڽӾ���
void inputGraph(int n, int graph[MAX][MAX]) {
    printf("��������м�ľ��루��ֱ�ӵ�·�ĳ��о����� %d ��ʾ����\n", INF);
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (i != j) {
                printf("���� %d ������ %d �ľ��룺", i, j);
                scanf("%d", &graph[i][j]);
                if (graph[i][j] == 0) {
                    graph[i][j] = INF; // ���޵�·����Ϊ�����
                }
            } else {
                graph[i][j] = 0; // �Խ����ϵ�ֵ��Ϊ0
            }
        }
    }
}

// ��ʾ�ڽӾ���
void displayGraph(int n, int graph[MAX][MAX]) {
    printf("�ڽӾ����ʾ�ĳ��м��������\n");
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (graph[i][j] == INF)
                printf("INF ");
            else
                printf("%3d ", graph[i][j]);
        }
        printf("\n");
    }
}

// Prim �㷨
void primMST(int n, int graph[MAX][MAX]) {
    int parent[MAX];    // �洢������
    int key[MAX];       // ѡ�����СȨֵ
    bool inMST[MAX];    // �Ƿ��������С��������

    // ��ʼ��
    for (int i = 0; i < n; i++) {
        key[i] = INF;
        inMST[i] = false;
    }
    key[0] = 0;       // �ӵ�һ�����п�ʼ
    parent[0] = -1;   // ��һ�������Ǹ��ڵ�

    for (int count = 0; count < n - 1; count++) {
        // �ҳ����� MST ����Ȩֵ��С�Ķ���
        int min = INF, u;
        for (int v = 0; v < n; v++)
            if (!inMST[v] && key[v] < min) {
                min = key[v];
                u = v;
            }
        inMST[u] = true;

        // �������ڽڵ��Ȩֵ
        for (int v = 0; v < n; v++)
            if (graph[u][v] && !inMST[v] && graph[u][v] < key[v]) {
                parent[v] = u;
                key[v] = graph[u][v];
            }
    }

    // �����С������
    printf("Prim�㷨���ɵ���С�����������ı߼���Ȩֵ��\n");
    int totalCost = 0;
    for (int i = 1; i < n; i++) {
        printf("�� %d - %d, Ȩֵ��%d\n", parent[i], i, graph[i][parent[i]]);
        totalCost += graph[i][parent[i]];
    }
    printf("��С�������Ĵ��ۣ�%d\n", totalCost);
}

// ����ߵĽṹ��
typedef struct {
    int u, v, weight;
} Edge;

// Kruskal �㷨
void kruskalMST(int n, int graph[MAX][MAX]) {
    Edge edges[MAX * MAX];
    int edgeCount = 0;

    // �������б�
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            if (graph[i][j] != INF && graph[i][j] != 0) {
                edges[edgeCount].u = i;
                edges[edgeCount].v = j;
                edges[edgeCount].weight = graph[i][j];
                edgeCount++;
            }
        }
    }

    // ������б�
    for (int i = 0; i < edgeCount - 1; i++) {
        for (int j = i + 1; j < edgeCount; j++) {
            if (edges[i].weight > edges[j].weight) {
                Edge temp = edges[i];
                edges[i] = edges[j];
                edges[j] = temp;
            }
        }
    }

    // Kruskal�㷨����MST
    int parent[MAX];
    for (int i = 0; i < n; i++)
        parent[i] = i;

    int totalCost = 0;
    printf("Kruskal�㷨���ɵ���С�����������ı߼���Ȩֵ��\n");

    int edgeSelected = 0;
    for (int i = 0; i < edgeCount && edgeSelected < n - 1; i++) {
        int u = edges[i].u;
        int v = edges[i].v;
        int weight = edges[i].weight;

        // ���Ҹ��ڵ�
        int rootU = u, rootV = v;
        while (rootU != parent[rootU])
            rootU = parent[rootU];
        while (rootV != parent[rootV])
            rootV = parent[rootV];

        if (rootU != rootV) { // �������ͬһ������
            printf("�� %d - %d, Ȩֵ��%d\n", u, v, weight);
            totalCost += weight;
            parent[rootU] = rootV; // �ϲ�����
            edgeSelected++;
        }
    }
    printf("��С�������Ĵ��ۣ�%d\n", totalCost);
}

// ������
int main() {
    int n;
    int graph[MAX][MAX];

    printf("��������е�����������6������");
    scanf("%d", &n);
    if (n < 6) {
        printf("������������6����\n");
        return 0;
    }

    inputGraph(n, graph);
    displayGraph(n, graph);

    printf("\n��ѡ���㷨��1. Prim 2. Kruskal\n");
    int choice;
    scanf("%d", &choice);

    if (choice == 1) {
        primMST(n, graph);
    } else if (choice == 2) {
        kruskalMST(n, graph);
    } else {
        printf("��Ч��ѡ��\n");
    }

    return 0;
}
