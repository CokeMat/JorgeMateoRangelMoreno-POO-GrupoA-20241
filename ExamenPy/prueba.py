import random
cad = "E"
letters_bank = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ"
    
cad += random.choice(letters_bank)
i = 0
    
while i < 4:                
    cad += str(random.randint(0,9))
    i += 1
    
print(cad)