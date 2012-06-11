#!/bin/bash
#
#  Ordenacion y Elimininacion de filas duplicadas
#	
#  GATE-ANNIE. 
#      A,H,L,P,R,S,T,U y V. Geonames
#      Organization y Person. JRCNames (Wikipedia) 
#  Versión 2 
#
sort A_Country_State_Region.lst | uniq -u > A_Country_State_Region_final.lst
sort airports.lst | uniq -u > airport_final.lst
sort H_Stream_Lake.lst | uniq -u > H_Stream_Lake_final.lst
sort L_Parks_Area.lst | uniq -u > L_Parks_Area_final.lst
sort Organization.lst | uniq -u > Organization_final.lst
sort P_City_Village.lst | uniq -u > P_City_Village_final.lst
sort Person.lst | uniq -u > Person_final.lst
sort R_Road_RailRoad.lst | uniq -u > R_Road_RailRoad_final.lst
sort S_Spot_Building_Farm.lst | uniq -u > S_Spot_Building_Farm_final.lst
sort T_Mountain_Hill_Rock.lst | uniq -u > T_Mountain_Hill_Rock_final.lst
sort U_Undersea.lst | uniq -u > U_Undersea_final.lst
sort V_Forest_Heath.lst | uniq -u > V_Forest_Heath_final.lst
