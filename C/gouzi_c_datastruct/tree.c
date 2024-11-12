#include <stdio.h>
#include <limits.h> // 使用INT_MAX来表示无穷大
#include <stdbool.h>

#define MAX 10        // 最大城市数
#define INF INT_MAX   // 表示无穷大的权值

// 输入邻接矩阵
void inputGraph(int n, int graph[MAX][MAX]) {
    printf("请输入城市间的距离（无直接道路的城市距离用 %d 表示）：\n", INF);
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (i != j) {
                printf("城市 %d 到城市 %d 的距离：", i, j);
                scanf("%d", &graph[i][j]);
                if (graph[i][j] == 0) {
                    graph[i][j] = INF; // 若无道路，设为无穷大
                }
            } else {
                graph[i][j] = 0; // 对角线上的值设为0
            }
        }
    }
}

// 显示邻接矩阵
void displayGraph(int n, int graph[MAX][MAX]) {
    printf("邻接矩阵表示的城市间距离网：\n");
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

// Prim 算法
void primMST(int n, int graph[MAX][MAX]) {
    int parent[MAX];    // 存储生成树
    int key[MAX];       // 选择的最小权值
    bool inMST[MAX];    // 是否包含在最小生成树中

    // 初始化
    for (int i = 0; i < n; i++) {
        key[i] = INF;
        inMST[i] = false;
    }
    key[0] = 0;       // 从第一个城市开始
    parent[0] = -1;   // 第一个城市是根节点

    for (int count = 0; count < n - 1; count++) {
        // 找出不在 MST 中且权值最小的顶点
        int min = INF, u;
        for (int v = 0; v < n; v++)
            if (!inMST[v] && key[v] < min) {
                min = key[v];
                u = v;
            }
        inMST[u] = true;

        // 更新相邻节点的权值
        for (int v = 0; v < n; v++)
            if (graph[u][v] && !inMST[v] && graph[u][v] < key[v]) {
                parent[v] = u;
                key[v] = graph[u][v];
            }
    }

    // 输出最小生成树
    printf("Prim算法生成的最小生成树包含的边及其权值：\n");
    int totalCost = 0;
    for (int i = 1; i < n; i++) {
        printf("边 %d - %d, 权值：%d\n", parent[i], i, graph[i][parent[i]]);
        totalCost += graph[i][parent[i]];
    }
    printf("最小生成树的代价：%d\n", totalCost);
}

// 定义边的结构体
typedef struct {
    int u, v, weight;
} Edge;

// Kruskal 算法
void kruskalMST(int n, int graph[MAX][MAX]) {
    Edge edges[MAX * MAX];
    int edgeCount = 0;

    // 构建边列表
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

    // 排序边列表
    for (int i = 0; i < edgeCount - 1; i++) {
        for (int j = i + 1; j < edgeCount; j++) {
            if (edges[i].weight > edges[j].weight) {
                Edge temp = edges[i];
                edges[i] = edges[j];
                edges[j] = temp;
            }
        }
    }

    // Kruskal算法构建MST
    int parent[MAX];
    for (int i = 0; i < n; i++)
        parent[i] = i;

    int totalCost = 0;
    printf("Kruskal算法生成的最小生成树包含的边及其权值：\n");

    int edgeSelected = 0;
    for (int i = 0; i < edgeCount && edgeSelected < n - 1; i++) {
        int u = edges[i].u;
        int v = edges[i].v;
        int weight = edges[i].weight;

        // 查找根节点
        int rootU = u, rootV = v;
        while (rootU != parent[rootU])
            rootU = parent[rootU];
        while (rootV != parent[rootV])
            rootV = parent[rootV];

        if (rootU != rootV) { // 如果不在同一集合中
            printf("边 %d - %d, 权值：%d\n", u, v, weight);
            totalCost += weight;
            parent[rootU] = rootV; // 合并集合
            edgeSelected++;
        }
    }
    printf("最小生成树的代价：%d\n", totalCost);
}

// 主函数
int main() {
    int n;
    int graph[MAX][MAX];

    printf("请输入城市的数量（至少6个）：");
    scanf("%d", &n);
    if (n < 6) {
        printf("城市数量不足6个！\n");
        return 0;
    }

    inputGraph(n, graph);
    displayGraph(n, graph);

    printf("\n请选择算法：1. Prim 2. Kruskal\n");
    int choice;
    scanf("%d", &choice);

    if (choice == 1) {
        primMST(n, graph);
    } else if (choice == 2) {
        kruskalMST(n, graph);
    } else {
        printf("无效的选择！\n");
    }

    return 0;
}
