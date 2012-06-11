#!/bin/bash
#
#  Ordenacion y Elimininacion de filas duplicadas
#	
#  GATE-ANNIE. 
#      A,H,L,P,R,S,T,U y V. Geonames
#      Organization y Person. JRCNames (Wikipedia) 
#  Versión 2 
#
sort A_Country_State_Region.lst airports.lst H_Stream_Lake.lst L_Parks_Area.lst P_City_Village.lst R_Road_RailRoad.lst S_Spot_Building_Farm.lst T_Mountain_Hill_Rock.lst U_Undersea.lst V_Forest_Heath.lst | uniq -c | sort -g -r > Count_Toponym.txt
