import math
import tkinter as tk
import sys


EMD = "Electric Mining Drill"
PJ = "Pumpjack"
AS1 = "Assembler 1"
AS2 = "Assembler 2"
AS3 = "Assembler 3"
HC = "Hand-crafted"
F = "Furnace"



class item:
    def __init__(self, recipe, craftTime, producedIn, amountProduced):
        self.recipe = recipe
        self.craftTime = craftTime
        self.producedIn = producedIn
        self.amountProduced = amountProduced
    
    def __str__(self):
        return f"Produces {self.amountProduced * (1 / self.craftTime)}/s in {self.producedIn} using {self.recipe}"



ironOre = item(None, 2, EMD, 1)
copperOre = item(None, 2, EMD, 1)

ironPlateRecipe = [(ironOre, 1)]
ironPlate = item(ironPlateRecipe, 3.2, F, 1)

copperPlateRecipe = [(copperOre, 2)]
copperPlate = (copperPlateRecipe, 3.2, F, 1)

gearRecipe = [(ironPlate, 2)]
gear = item(gearRecipe, 0.5, AS3, 1)

yellowBeltRecipe = [(gear, 1), (ironPlate, 1)]
yellowBelt = item(yellowBeltRecipe, 0.5, AS3, 2)




def productionMenu():
    print("pb")

def intermediateMenu():
    print("ib") 

def militaryMenu():
    print("mm")
    
def mainWindow():
    mainWindow = tk.Tk()
    mainWindow.title("Factorio Optimizer")
    mainWindow.geometry("800x800")
    mainWindow.configure(background="#282828")
    mainWindow.attributes('-fullscreen', True)

    for i in range(2):
        mainWindow.rowconfigure(i, weight=1)

    for i in range(4):
        mainWindow.columnconfigure(i, weight=1)



    mainWindowTopLabel = tk.Label(mainWindow, text = "Click a button to see items in the catagory", foreground="white", font=("", 60, "bold"), background="#282828")
    mainWindowTopLabel.grid(row=0,column=0, sticky="nsew", columnspan=4)

    mainCloseButton = tk.Button(mainWindow, text="X", font=("", 30, "bold"), command=sys.exit, foreground="black", background="red", relief="raised", padx=10)
    mainCloseButton.grid(row=0, column=3, sticky="ne")


    logisticsButton = tk.Button(mainWindow, text = "Logistics", font=("", 30, "bold"), command=logisticsMenu)
    logisticsButton.grid(row=1, column=0, sticky="nsew")

    productionButton = tk.Button(mainWindow, text = "Production", font=("", 30, "bold"), command=productionMenu)
    productionButton.grid(row=1, column=1, sticky="nsew")

    intermediateButton = tk.Button(mainWindow, text = "Intermediate\nProducts", font=("", 30, "bold"), command=intermediateMenu)
    intermediateButton.grid(row=1, column=2, sticky="nsew")

    militaryButton = tk.Button(mainWindow, text = "Military", font=("", 30, "bold"), command=militaryMenu)
    militaryButton.grid(row=1, column=3, sticky="nsew")

    mainWindow.mainloop()


def logisticsMenu():
    logiWindow = tk.Tk()
    logiWindow.title("Factorio Omptimizer: Logistics")
    logiWindow.geometry("800x800")
    logiWindow.configure(background="#282828")
    logiWindow.attributes('-fullscreen', True)
    tk.Toplevel(logiWindow)
    
    for i in range(4):
        logiWindow.rowconfigure(i, weight=1)

    for i in range(3):
        logiWindow.columnconfigure(i, weight=1)
    
    logiTopLabel = tk.Label(logiWindow, text="Logistics", font=("", 60, "bold"), foreground="white", background="#282828")
    logiTopLabel.grid(row=0, column=0, columnspan=3)

    logiBackButton = tk.Button(logiWindow, text="<", font=("", 30, "bold"), command=logiWindow.destroy, foreground="white", background="#63E5FF", padx=10)
    logiBackButton.grid(row=0, column=0, sticky="nw")
    
    logiCloseButton = tk.Button(logiWindow, text="X", font=("", 30, "bold"), command=sys.exit, foreground="black", background="red", padx=10)
    logiCloseButton.grid(row=0, column=2, sticky="ne")

    containerButton = tk.Button(logiWindow, text = "Containers", font=("", 30, "bold"), command=logiWindow.destroy)
    containerButton.grid(row=1, column=0, sticky="nesw")
    
    beltButton = tk.Button(logiWindow, text = "Belts", font=("", 30, "bold"), command=print(yellowBelt))
    beltButton.grid(row=1, column=1, sticky="nesw")

    inserterButton = tk.Button(logiWindow, text = "Inserters", font=("", 30, "bold"), command=logiWindow.destroy)
    inserterButton.grid(row=1, column=2, sticky="nesw")

    ppButton = tk.Button(logiWindow, text = "Pipes/Power", font=("", 30, "bold"), command=logiWindow.destroy)
    ppButton.grid(row=2, column=0, sticky="nesw")

    railButton = tk.Button(logiWindow, text = "Rails", font=("", 30, "bold"), command=logiWindow.destroy)
    railButton.grid(row=2, column=1, sticky="nesw")

    vehicleButton = tk.Button(logiWindow, text = "Vehicles", font=("", 30, "bold"), command=logiWindow.destroy)
    vehicleButton.grid(row=2, column=2, sticky="nesw")

    botButton = tk.Button(logiWindow, text = "Robots", font=("", 30, "bold"), command=logiWindow.destroy)
    botButton.grid(row=3, column=0, sticky="nesw")

    circuitButton = tk.Button(logiWindow, text = "Circuits", font=("", 30, "bold"), command=logiWindow.destroy)
    circuitButton.grid(row=3, column=1, sticky="nesw")

    tileButton = tk.Button(logiWindow, text = "Tiles", font=("", 30, "bold"), command=logiWindow.destroy)
    tileButton.grid(row=3, column=2, sticky="nesw")






mainWindow()

    
