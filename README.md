# Seedcracker
Cracks lift/half/structureseeds from structures, pillarseeds, slimechunks and gateways.

Bedrock edition support isnt fully implemented yet

How to use:

Input chunk coordinates of structures,
you need 20 liftable bits to crack a structureseed, only 16 if you have the pillarseed.
Here is a list of structures and their bityield:
```
Desert / Jungle Pyramid: 6 Liftable bits.
Igloo: 6 Liftable bits.
Swamphut: 6 liftable bits.
Outpost: 6 liftable bits.
Shipwreck: 4 liftable bits.
Oceanruin: 4 liftable bits.
Village: 2 Liftable bits.
Trialchamber: 2 Liftable bits.
Trailruin: 2 Liftable bits.
Mansion: 2+ Liftable bits.
Slimechunk: 1 Liftable bit.
Gateway: 2 Liftable bits.
```

Note, using too many structures of the same type or only Desert / Jungle Pyramids, Igloos, Swamphuts and Outposts can result in alot of "imposter" seeds, i recommend using non liftable structures aswell to reduce results, If you get too many results the programm might crash.

You can find a pillarcracker here: github.com/Epic10l2/Simple-Pillarcracker

Gateway indecies:

```
0 = x 96 z 0
1 = x 91 z 29
2 = x 77 z 56
3 = x 56 z 77
4 = x 29 z 91
5 = x -91 z -1
6 = x -30 z 91
7 = x -57 z 77
8 = x -78 z 56
9 = x -92 z 29
10 = x -96 z -1
11 = x -92 z -30
12 = x -78 z -57
13 = x -57 z -78
14 = x -30 z -92
15 = x 0 z -96
16 = x 29 z -92
17 = x 56 z -78
18 = x 77 z -57
19 = x 91 z -30
```

Important: Slimechunks are currently broken, they will be fixed in the next version
