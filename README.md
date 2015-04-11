# MyRepo

The Probblem can be tested with mvn clean install

Outpout:

Output is is printed as a part of System .out.println

Junit Test Case: 
Currently Junit test cases is covering  
1)optimized route for 2 bags . 
2)For Arival of a Bag.
3)When source and sestination is same

Dijkstra's  algorithm is used to find the minimal distance betwwen twe Nodes.

For different test data like Graph structure, Flight Details, one need to modify the test data in Junit test cases

Below Is the sample output.

************graph Start*************************
Edge_0 : Concourse_A_Ticketing------>A5 distance :5
Edge_1 : A5------>BaggageClaim distance :5
Edge_2 : A4------>A10 distance :2
Edge_3 : A5------>A1 distance :6
Edge_4 : A1------>A2 distance :1
Edge_5 : A2------>A3 distance :1
Edge_6 : A3------>A4 distance :1
Edge_7 : A10------>A9 distance :1
Edge_8 : A9------>A8 distance :1
Edge_9 : A8------>A7 distance :1
Edge_10 : A7------>A6 distance :4
Edge_11 : A4------>A5 distance :8
Edge_12 : A3------>A6 distance :1
Edge_13 : A6------>A5 distance :1

************graph End*************************
**********Flight To Gate  Start--------
Flight =Flight [id=UA18, destination=JFK] Gate =A5
Flight =Flight [id=UA11, destination=LAX] Gate =A1
Flight =Flight [id=UA17, destination=JFK] Gate =A4
Flight =Flight [id=UA10, destination=MIA] Gate =A1
Flight =Flight [id=UA16, destination=JFK] Gate =A3
Flight =Flight [id=UA15, destination=JFK] Gate =A2
Flight =Flight [id=UA14, destination=JFK] Gate =A2
Flight =Flight [id=UA13, destination=JFK] Gate =A2
Flight =Flight [id=UA12, destination=JFK] Gate =A1
**********Flight To Gate  End--------
*************Section: Bags Source and Destination Starts*************
RoutingItem [id=001, source=A8, destination=A2, item=Baggage [flight=Flight [id=UA14, destination=JFK]]]
RoutingItem [id=001, source=A8, destination=A2, item=Baggage [flight=Flight [id=UA14, destination=JFK]]]
RoutingItem [id=002, source=A1, destination=A5, item=Baggage [flight=Flight [id=UA18, destination=JFK]]]
RoutingItem [id=003, source=A1, destination=A5, item=Baggage [flight=Flight [id=UA18, destination=JFK]]]
RoutingItem [id=004, source=A1, destination=A1, item=Baggage [flight=Flight [id=UA18, destination=JFK]]]
RoutingItem [id=005, source=Concourse_A_Ticketing, destination=A1, item=Baggage [flight=Flight [id=UA18, destination=JFK]]]
*************Section: Bags Source and Destination Ends*************
***************Optimal Path Start********************
001 [A8, A9, A10, A4, A3, A2] :  6
002 [A1, A2, A3, A6, A5] :  4
003 [A1, A2, A3, A6, A5] :  4
004 [A1] :  0
005 [Concourse_A_Ticketing, A5, A6, A3, A2, A1] :  9
006 [A9, A10, A4, A3, A6, A5, BaggageClaim] :  11
***************Optimal Path End********************




