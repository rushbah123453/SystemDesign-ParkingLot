
Problem Statement :

I own a parking lot that can hold up to 'n' cars at any given point in time. Each slot is
given a number starting at 1 increasing with increasing distance from the entry point
in steps of one. I want to create an automated ticketing system that allows my
customers to use my parking lot without human intervention.
When a car enters my parking lot, I want to have a ticket issued to the driver. The
ticket issuing process includes us documenting the registration number (number
plate) and the colour of the car and allocating an available parking slot to the car
before actually handing over a ticket to the driver (we assume that our customers are
nice enough to always park in the slots allocated to them). The customer should be
allocated a parking slot which is nearest to the entry. At the exit the customer returns
the ticket with the time the car was parked in the lot, which then marks the slot they
were using as being available. Total parking charge should be calculated as per the
parking time. Charge applicable is $10 for first 2 hours and $10 for every additional
hour.
We interact with the system via a simple set of commands which produce a specific
output. Please take a look at the example below, which includes all the commands

you need to support - they're self explanatory. The system should accept a filename
as a parameter at the command prompt and read the commands from that file.



Assumptions :  

1) Single Level Parking slot

2) Single Entrance and Exit Point

3) Parking slots are of 1 unit and all vehicle acquires 1 unit , no premium spots or as such

4) All vehicle parking  costs same , only variable is time 

5) In Question , color/colour is asked to take as input from user , However it is not used anywhere ,So I have displayed in the status

Steps to Run the Assignment

Fire the below command to run the Assignment :

1st command will run the code taking input from resources/parking_lot_file_inputs.txt
2nd Command will ask you for Input 


1)./parking_lot.sh  src/main/resources/parking_lot_file_inputs.txt

This above command will pick up the input file from the resources/parking_lot_file_inputs.txt and execute the code.


2) ./parking_lot.sh 

This above command will pick up the jar file from the target/ path and execute the code.


####  Requirments  ####

1) JDK 1.8 and above

2) Junit 4.12

Input :

create_parking_lot 6
park KA-01-HH-1234 black
park KA-01-HH-9999 white
park KA-01-BB-0001 red
park KA-01-HH-7777 blue
park KA-01-HH-2701 black
park KA-01-HH-3141 orange
leave KA-01-HH-3141 4
status
park KA-01-P-333 red
park DL-12-AA-9999 white
leave KA-01-HH-1234 4
leave KA-01-BB-0001 6
leave DL-12-AA-9999 2
park KA-09-HH-0987 black
park CA-09-IO-1111 green
park KA-09-HH-0123 grey
status


Output :

Slot No.                Registration No.                                Color
1                       KA-09-HH-0987                                   black
2                       KA-01-HH-9999                                   white
3                       CA-09-IO-1111                                   green
4                       KA-01-HH-7777                                   blue
5                       KA-01-HH-2701                                   black
6                       KA-01-P-333                                     red




 



