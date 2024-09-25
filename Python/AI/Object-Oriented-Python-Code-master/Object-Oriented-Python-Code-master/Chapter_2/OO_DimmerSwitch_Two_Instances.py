# DimmerSwitch class with Test Code

# DimmerSwitch class

class DimmerSwitch():
    def __init__(self,label):
        self.label = label
        self.isOn = False
        self.brightness = 0

        
    def turnOn(self):
        self.isOn = True

    def turnOff(self):
        self.isOn = False

    def raiseLevel(self):
        if self.brightness < 10:
            self.brightness = self.brightness + 1

    def lowerLevel(self):
        if self.brightness > 0:
            self.brightness = self.brightness - 1

    # Extra method for debugging
    def showState(self):
        print("Label",self.label)
        print('Switch is on?', self.isOn)
        print('Brightness is:', self.brightness)
        print()

# Main code

oDimmer1 = DimmerSwitch('Dimmer1' )
oDimmer1.turnOn()
oDimmer1.raiseLevel()
oDimmer1.raiseLevel()

oDimmer2 = DimmerSwitch('Dimmer2' )
oDimmer2.turnOn()
oDimmer2.raiseLevel()
oDimmer2.raiseLevel()
oDimmer2.raiseLevel()

oDimmer3 = DimmerSwitch('Dimmer3' )

oDimmer1.showState()
oDimmer2.showState()
oDimmer3.showState()




