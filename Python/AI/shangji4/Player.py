import pygame

class Player:
    def __init__(self, window, window_width, window_height):
        self.window = window
        self.color = (255, 255, 255)  # 白色
        self.size = 30
        self.x = window_width // 2
        self.y = window_height // 2
        self.speed = 5
        self.window_width = window_width
        self.window_height = window_height

    def handle_keys(self):
        keys = pygame.key.get_pressed()
        if keys[pygame.K_LEFT]:
            self.x -= self.speed
        if keys[pygame.K_RIGHT]:
            self.x += self.speed
        if keys[pygame.K_UP]:
            self.y -= self.speed
        if keys[pygame.K_DOWN]:
            self.y += self.speed

        # 限制边界
        self.x = max(0, min(self.window_width - self.size, self.x))
        self.y = max(0, min(self.window_height - self.size, self.y))

    def draw(self):
        pygame.draw.rect(self.window, self.color, (self.x, self.y, self.size, self.size))
