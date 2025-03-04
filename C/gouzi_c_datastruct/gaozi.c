// 引言部分
// 大家好，今天我们来讲解如何利用 Prim 和 Kruskal 算法来构建一个地区内所有城市之间的最小生成树。
// 最小生成树的目标是找到一种方式连接所有城市，使得连接的总权值最小。
// 最小生成树在网络设计和路径优化方面有很多应用，比如铺设电网、城市道路规划等。
// 在本视频中，我们会从代码的输入模块开始，一步一步地解释各个部分，包括城市距离的输入、最小生成树的构建过程以及最终的结果输出。
// 我们将会详细探讨两种经典算法——Prim 和 Kruskal 算法，它们各自有不同的适用场景和特点。
// 代码概述
// 这段代码的核心是实现最小生成树的构建，我们采用了邻接矩阵来存储城市之间的距离。
// 首先，用户输入城市数量和每对城市之间的距离，然后选择使用 Prim 算法还是 Kruskal 算法来构建最小生成树。
// 最后，我们输出最小生成树中的所有边及其总代价。
// 代码分为几个模块：
// 输入模块：负责读取用户输入的城市数量和城市之间的距离。
// 显示模块：用于显示输入的邻接矩阵，方便用户检查输入。
// 最小生成树构建模块：使用 Prim 或 Kruskal 算法计算最小生成树。
// 主函数模块：负责协调所有模块，完成整个流程。
// 输入模块讲解
// 我们先来看代码的输入部分。在这部分，我们使用了一个二维数组 graph[MAX][MAX] 来表示城市之间的距离网络。
// 用户需要输入城市数量，至少为 6 个，然后逐对输入城市之间的距离。
// 注意，如果两个城市之间没有直接的道路连接，我们用一个无穷大的值来表示，这个值在代码中使用 INF 代替。
// 代码中，我们通过双重循环来获取用户输入，每次提示用户输入两城市之间的距离。
// 如果没有直接的连接，我们让用户输入 0，然后在代码中将其设置为 INF。
// 对角线元素（即城市到自身的距离）设置为 0。
// 显示模块讲解
// 输入完成后，我们会显示城市之间的邻接矩阵。
// 这一步可以帮助用户确认他们输入的距离信息是否正确。
// 代码中，我们通过一个嵌套循环遍历邻接矩阵，将每个城市之间的距离输出。
// 如果某对城市之间的距离为 INF，我们将其显示为 “INF”，以便清楚地看到哪些城市之间是没有直接连接的。
// Prim 算法讲解
// 现在我们进入 Prim 算法的部分。
// Prim 算法的核心思想是，从某个起点开始，通过不断选择与已选节点相连的最小权值边来扩展最小生成树，直到所有节点都被包含在内。
// 代码中，我们使用了三个数组：
// parent[MAX]：用于存储生成树中的父节点信息。
// key[MAX]：存储每个节点到最小生成树的最小权值，用于决定下一个加入生成树的节点。
// inMST[MAX]：用于标记每个节点是否已被加入最小生成树。
// 我们从节点 0 开始，将其 key 值设为 0，表示从这个节点开始构建生成树。
// 然后，我们通过一个循环逐步选择不在最小生成树中且 key 值最小的节点，将其加入生成树，并更新与之相邻节点的 key 值和 parent 信息。
// 在循环结束后，我们遍历 parent 数组，输出生成树中的所有边以及它们的权值，并计算总的代价。
// Kruskal 算法讲解
// 接下来是 Kruskal 算法的部分。
// Kruskal 算法是基于边的选择的算法，它的思想是从所有边中按权值从小到大排序，逐步选择边，确保没有形成环，直到构造出最小生成树。
// 代码实现中，我们首先构建一个边的列表，然后对这些边按权值进行排序。
// 排序后，我们逐一选择边，使用并查集来判断是否形成环。
// 如果选择的边不会导致环的形成，就将其加入最小生成树，并更新并查集的父节点信息。
// 对于并查集部分，我们使用了路径压缩的技术来优化查找根节点的效率，这样能够保证算法在处理较大规模数据时的效率。
// 最终，我们输出 Kruskal 算法生成的最小生成树中的所有边及其权值，并计算总的代价。
// 总结部分
// 总结一下，Prim 和 Kruskal 算法都是用于构造最小生成树的经典算法，它们的主要区别在于：
// Prim 算法更适合用于稠密图，因为它每次需要从已加入生成树的节点中找到最小边，与所有其他未加入的节点进行比较。
// Kruskal 算法则更适合稀疏图，因为它通过对所有边进行排序，逐步选择边来构建生成树，更加高效。
// 本视频通过代码示例演示了这两个算法的实现过程，并比较了它们各自的适用场景和优缺点。
// 希望通过这次讲解，大家能够更好地理解最小生成树的构建以及贪心算法在图论中的应用。
// 感谢大家的观看，如果有任何问题，欢迎在评论区提出。 这样排版后的内容更加整齐清晰，可以更方便地阅读和理解。如果您有任何其他要求或需要进一步的修改，请告诉我！