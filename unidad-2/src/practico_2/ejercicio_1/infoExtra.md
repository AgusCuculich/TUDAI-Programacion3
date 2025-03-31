## Imagen ilustrativa del recorrido para devolver las hojas (getLeaves)

[recorridoHojas.jpg](../../../../img/recorridoHojas.jpg)

## Explicación gráfica del funcionamiento de heightOfTree

        6
       / \
      2   10
     / \   / \
    1   4 8  11
       / \
      7   9

heightOfTree(6)  
├── heightOfTree(2)  
│   ├── heightOfTree(1) → devuelve 0  
│   ├── heightOfTree(4)  
│       ├── heightOfTree(7) → devuelve 0  
│       ├── heightOfTree(9) → devuelve 0  
│       🔄 Math.max(0, 0) + 1 → 1
│   🔄 Math.max(0, 1) + 1 → 2  
│  
├── heightOfTree(10)  
│   ├── heightOfTree(8) → devuelve 0
│   ├── heightOfTree(11) → devuelve 0  
│   🔄 Math.max(0, 0) + 1 → 1  
│  
🔄 Math.max(2, 1) + 1 → **3**