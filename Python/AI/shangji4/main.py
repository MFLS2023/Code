import pygame
import sys
from Ball import Ball
from Player import Player
from Obstacle import Obstacle

# 常量定义
BLACK = (0, 0, 0)
WINDOW_WIDTH = 640
WINDOW_HEIGHT = 480
FRAMES_PER_SECOND = 30

# 初始化 Pygame
pygame.init()
window = pygame.display.set_mode((WINDOW_WIDTH, WINDOW_HEIGHT))
pygame.display.set_caption("扩展小游戏")
clock = pygame.time.Clock()

# 创建游戏对象
ball = Ball(window, WINDOW_WIDTH, WINDOW_HEIGHT)
player = Player(window, WINDOW_WIDTH, WINDOW_HEIGHT)
obstacles = [Obstacle(window, WINDOW_WIDTH, WINDOW_HEIGHT) for _ in range(3)]  # 生成3个障碍物

# 初始化分数
score = 0
font = pygame.font.Font(None, 36)

# 游戏循环
while True:
    # 事件处理
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            sys.exit()

    # 更新玩家和小球位置
    player.handle_keys()
    ball.update()

    # 碰撞检测
    player_rect = pygame.Rect(player.x, player.y, player.size, player.size)
    ball_rect = pygame.Rect(ball.x, ball.y, ball.width, ball.height)

    if player_rect.colliderect(ball_rect):
        score += 1  # 碰到小球时增加分数

    for obstacle in obstacles:
        obstacle_rect = pygame.Rect(obstacle.x, obstacle.y, obstacle.width, obstacle.height)
        if player_rect.colliderect(obstacle_rect):
            print("碰到障碍物，游戏结束！")
            pygame.quit()
            sys.exit()

    # 绘制元素
    window.fill(BLACK)
    ball.draw()
    player.draw()
    for obstacle in obstacles:
        obstacle.draw()

    # 显示分数
    score_text = font.render(f"Score: {score}", True, (255, 255, 255))
    window.blit(score_text, (10, 10))

    # 更新屏幕
    pygame.display.update()
    clock.tick(FRAMES_PER_SECOND)
