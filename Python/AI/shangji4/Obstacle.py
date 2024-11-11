import pygame
import random

class Obstacle:
    def __init__(self, window, window_width, window_height):
        self.window = window
        self.width = 30
        self.height = 30
        self.color = (255, 0, 0)  # 红色表示障碍物
        self.x = random.randint(0, window_width - self.width)
        self.y = random.randint(0, window_height - self.height)

    def draw(self):
        pygame.draw.rect(self.window, self.color, (self.x, self.y, self.width, self.height))
