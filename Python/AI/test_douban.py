import warnings
warnings.filterwarnings('ignore')
from collections import Counter
import pandas as pd
import numpy as np
import matplotlib
import matplotlib.pyplot as plt
df = pd.read_csv(r"D:\File\study\郑航\AI\2307080235张城\book.csv")
df
df.reset_index(drop = True, inplace = True)
df.replace('None',np.nan,inplace=True)
df.isnull().sum()

df.dropna(axis=0,subset=['作者','出版社','出版时间','数','价格','评分','评论数量'],
          how='any',inplace=True)
df.reset_index(drop=True,inplace=True)
df.isna().sum()
df['出版时间'] = pd.to_datetime(df['出版时间'], errors='coerce')
df = df.dropna(subset=['出版时间'])
df['出版时间'] = df['出版时间'].dt.strftime('%Y-%m-%d')
df['出版时间']
df['评分'] = pd.to_numeric(df['评分'], errors='coerce')
df['评论数量'] = pd.to_numeric(df['评论数量'], errors='coerce')
print(df['评分'])
print(df['评论数量'])
df['数'].fillna(0, inplace=True)  # 先将NaN值填充为0
df['数'].value_counts()  # 然后进行计数
df['价格'] = df['价格'].astype(str)
df['价格'] = df['价格'].apply(lambda x: x.replace(',', '').replace(' ', ''))
df = df[df['价格'].str.replace('.', '').str.isnumeric() & df['价格'].str[-1].str.isnumeric()]
df['价格'] = df['价格'].astype(float)
df['价格']
df.drop_duplicates(subset='书名', keep='first', inplace=True)
df
df.to_excel(r"D:\File\study\郑航\AI\2307080235张城\1.xls", index=False)
df
publishers = df['出版社'].value_counts()
publishers = publishers[publishers > 200]
publishers_f = df[df['出版社'].isin(publishers.index)]
publishers_f[['出版社', '评分']].to_excel(r"D:\File\study\郑航\AI\2307080235张城\2.xls", index=False)
publishers_f[['出版社', '评分']]
writer=df['作者'].value_counts()
writer=pd.DataFrame(writer)
writer.reset_index(inplace=True)
writer.rename(columns={'index':'作家','作者':'作品数量'},inplace=True)
writer = writer[writer['作品数量'] >= 10]
writer.to_excel(r"D:\File\study\郑航\AI\2307080235张城\3.xls", index=False)
writer
lst1=writer[writer['作品数量']>=10]['作家'].tolist()
writer_rank=df[df['作者'].isin(lst1)].groupby(by='作者',as_index=False).agg(
    {'评分':np.mean}).sort_values(by='评分',ascending=False).reset_index(drop=True).head(20)
writer_rank.to_excel(r"D:\File\study\郑航\AI\2307080235张城\4.xls",index = False)
writer_rank
year_counts = df['出版时间'].astype('datetime64[Y]').dt.year.value_counts().sort_index()
plt.plot(year_counts.index, year_counts.values)
plt.xlabel('年份')
plt.ylabel('作品出版数量')
plt.title('2307080235张城\n各年作品出版数量折线图')
plt.savefig(r"D:\File\study\郑航\AI\2307080235张城\1.png")
plt.show()
# 生成价格区间
s=[]
for i in range(20):
    s.append((i*10,i*10+10))
s.append((200,1000))
# bins = pd.IntervalIndex.from_tuples([(0,10),(10,20),(20,30),(30, 40),(40, 50),
#                                      (50,60),(60,70),(70,80),(80,90),(90,100),
#                                      (100,110),(110,120),(120,130),(130, 140),(140, 150),
#                                      (150,160),(160,170),(170,180),(180,190),(190,200),(200,10000)])
bins = pd.IntervalIndex.from_tuples(s)
# 使用cut函数将价格数据划分到对应的区间
price_bins = pd.cut(df['价格'], bins=bins)

# 统计每个区间内的图书数量
price_counts = price_bins.value_counts(sort=False)

# 绘制直方图
price_counts.plot(kind='bar', xticks=range(len(price_counts)),
                  title='各价位作品数量直方图')

plt.xlabel('价格')
plt.ylabel('作品数量')

# 设置x轴刻度标签
plt.xticks(range(len(price_counts)), price_counts.index.astype(str), rotation=45)

# 保存和显示图像
plt.savefig(r"D:\File\study\郑航\AI\2307080235张城\2.png")
plt.show()
publisher_counts = df['出版社'].value_counts().head(10)
publisher_counts.plot(kind='bar', title='2307080235张城\n前10名出版社出版作品数量')
plt.xlabel('出版社', fontproperties='SimHei')
plt.ylabel('数量',fontproperties='SimHei' )
plt.savefig(r"D:\File\study\郑航\AI\2307080235张城\3.png")
plt.show()
# 按出版社计算评分均值
publisher_ratings = df.groupby('出版社')['评分'].mean().nlargest(35)
# 创建一个新的DataFrame来保存出版社和评分数据
data = pd.DataFrame({'出版社': publisher_ratings.index, '评分': publisher_ratings.values})

# 绘制折线图
plt.plot(data['出版社'], data['评分'], marker='o')

plt.title('2307080235张城\n前35名各出版社作品评分折线图')
plt.xlabel('出版社')
plt.ylabel('评分')
plt.xticks( rotation=90)
# 保存和显示图像
plt.savefig(r"D:\File\study\郑航\AI\2307080235张城\4.png")
plt.show()
s=[]
j=5
for i in range(25):
    s.append((j+i/5,j+(i+1)/5))

# 生成评分区间
bins = pd.IntervalIndex.from_tuples(s)

# 使用cut函数将价格数据划分到对应的区间
price_bins = pd.cut(df['评分'], bins=bins)

# 统计每个区间内的图书数量
price_counts = price_bins.value_counts(sort=False)

# 绘制直方图
price_counts.plot(kind='bar', xticks=range(len(price_counts)),
                  title='2307080235张城\n各价位作品数量直方图')

plt.xlabel('评分')
plt.ylabel('数量')

# 设置x轴刻度标签
plt.xticks(range(len(price_counts)), price_counts.index.astype(str), rotation=-90)

# 保存和显示图像
plt.savefig(r"D:\File\study\郑航\AI\2307080235张城\5.png")
plt.show()