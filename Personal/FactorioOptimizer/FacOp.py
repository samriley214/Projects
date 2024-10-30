import math
import tkinter as tk
import sys


EMD = "Electric Mining Drill"
PJ = "Pumpjack"
AS1 = "Assembler 1"
AS2 = "Assembler 2"
AS3 = "Assembler 3"
HC ="Hand-crafted"
F = "Furnace"

crafterDict = {"Electric Mining Drill" : 1, "Pumpjack" : 1, "Assembling Machine 1" : 0.5, "Assembling Machine 2" : 0.75, "Assembling Machine 3" : 1.25, "Hand-craft" : 1, "Stone Furnace" : 0.3125, "Steel Furnace" : 0.625 }



class item:
    def __init__(self, name, recipe, craftTime, producedIn, amountProduced):
        self.recipe = recipe
        self.craftTime = craftTime
        self.producedIn = producedIn
        self.amountProduced = amountProduced
        self.name = name
        self.itemsPerSecond = (self.amountProduced * (1 / self.craftTime))
    
    def __str__(self):
        str = f"Produces {self.amountProduced * (1 / self.craftTime)}/s in {self.producedIn}"
        if self.recipe:
            str += " using "
            for ingredients, quantity in self.recipe:
                str += f"{quantity, ingredients.name} "
            return str
        else:
            return str


ironOre = item("Iron Ore", None, 2, "Electric Mining Drills", 1)
copperOre = item("Copper Ore", None, 2, "Electric Mining Drills", 1)

ironPlateRecipe = [(ironOre, 1)]
ironPlate = item("Iron Plate", ironPlateRecipe, 3.2, "Furnaces", 1)

copperPlateRecipe = [(copperOre, 2)]
copperPlate = ("Copper Plate", copperPlateRecipe, 3.2, "Furnaces", 1)

gearRecipe = [(ironPlate, 2)]
gear = item("Gear", gearRecipe, 0.5, "Assembling Machines", 1)

yellowBeltRecipe = [(gear, 1), (ironPlate, 1)]
yellowBelt = item("Yellow Transporter Belt", yellowBeltRecipe, 0.5, "Assembling Machines", 2)

copperWireRecipe = [(copperPlate, 1)]
copperWire = item("Copper Wire", copperWireRecipe, 0.5, "Assembling Machines", 2)

greenCircuitRecipe = [(copperWire, 3), (ironPlate, 1)]
greenCircuit = item("Green Circuit", greenCircuitRecipe, 0.5, "Assembling Machines", 1)

itemsDict = {"Yellow Transporter Belt" : yellowBelt, "Gear" : gear, "Iron Ore" : ironOre, "Copper Ore" : copperOre, "Green Circuit" : greenCircuit, "Copper Wire" : copperWire}


def calculateItemsNeeded():
    global selectedItem, selectedCrafter, itemsNeededLabel, itemsPerSecondEntry

    
    selectedCrafterName = selectedCrafter.get()
    productionModifier = crafterDict.get(selectedCrafterName)

    selectedItemName = selectedItem.get()
    selectedItem = itemsDict.get(selectedItemName)

    wantedPerSecond = itemsPerSecondEntry.get()

    if selectedItem:
        neededCrafters = (float(wantedPerSecond) / (selectedItem.itemsPerSecond * productionModifier))
        itemsNeededLabel.config(text=f"You need {math.ceil(neededCrafters)} {selectedCrafterName}s to make {(selectedItem.itemsPerSecond * neededCrafters) * productionModifier}/s")
    else:
        itemsNeededLabel.config(text="Nothing Selected")

def mainWindow():
    global selectedItem, selectedCrafter, itemsNeededLabel, itemsPerSecondEntry


    mainWindow = tk.Tk()
    mainWindow.title("Factorio Optimizer")
    mainWindow.geometry("800x800")
    mainWindow.configure(background="#282828")
    mainWindow.attributes('-fullscreen', True)

    for i in range(2):
        mainWindow.rowconfigure(i, weight=1)

    for i in range(4):
        mainWindow.columnconfigure(i, weight=1)



    mainWindowTopLabel = tk.Label(mainWindow, text = "Use the dropdown to select and item and\nthen enter how many you need per second", foreground="white", font=("", 60, "bold"), background="#282828")
    mainWindowTopLabel.grid(row=0,column=0, sticky="nsew", columnspan=4)

    mainCloseButton = tk.Button(mainWindow, text="X", font=("", 30, "bold"), command=sys.exit, foreground="black", background="red", relief="raised", padx=10)
    mainCloseButton.grid(row=0, column=3, sticky="ne")

    itemsPerSecondEntry = tk.Entry(mainWindow, width=20)
    itemsPerSecondEntry.configure(font=("", 15, "bold"))
    itemsPerSecondEntry.grid(row=1, column=0, sticky="n")
    
    
    selectedItem = tk.StringVar(mainWindow)
    selectedItem.set("Item")
    itemDropdownOptions = list(itemsDict.keys())
    itemDropdown = tk.OptionMenu(mainWindow, selectedItem, *itemDropdownOptions)
    itemDropdown.configure(font=("", 30, "bold"), foreground="white", background="#282828", relief="flat", wraplength=300)
    itemDropdown.grid(row=1, column=0, sticky = "w")

    selectedCrafter = tk.StringVar(mainWindow)
    selectedCrafter.set("Crafter")
    crafterDropdownOptions = list(crafterDict.keys())
    crafterDropdown = tk.OptionMenu(mainWindow, selectedCrafter, *crafterDropdownOptions)
    crafterDropdown.configure(font=("", 30, "bold"), foreground="white", background="#282828", relief="flat", wraplength=300)
    crafterDropdown.grid(row=1, column=0, sticky = "e")

    itemsNeededLabel = tk.Label(mainWindow, text="", font=("", 30), wraplength=800)
    itemsNeededLabel.grid(row=1, column=2, columnspan=2, sticky="nesw")

    calculateButton = tk.Button(mainWindow, text="Calculate", font=("",30,"bold"), command=calculateItemsNeeded)
    calculateButton.grid(row=3, column=0, sticky="nesw")

    
    mainWindow.mainloop()










mainWindow()

    
