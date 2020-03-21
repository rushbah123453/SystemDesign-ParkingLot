package parking_lot.controller;

import parking_lot.exception.ErrorCode;
import parking_lot.exception.ParkingException;
import parking_lot.util.InputValidation;

import java.io.*;

public class ParkingController {
    public static void execute(String args[]) {
        System.out.println(args);
        ParkingHandlerMapping parkingHandlerMapping = new ParkingHandlerMapping();
        InputValidation validation = new InputValidation();
        BufferedReader bufferReader = null;
        String input = null;
        try {
            System.out.println("\n");
            printUsage();
            switch (args.length) {
                case 0: // Input from terminal
                {
                    System.out.println("Enter :");
                    while (true) {
                        try {
                            bufferReader = new BufferedReader(new InputStreamReader(System.in));
                            input = bufferReader.readLine().trim();
                            if (input.equalsIgnoreCase("end")) {
                                break;
                            } else {
                                if (validation.validateInput(input.trim())) {
                                    try {
                                        parkingHandlerMapping.execute(input.trim());
                                    } catch (Exception e) {
                                        System.out.println(e.getMessage());
                                    }
                                } else {
                                    System.out.println("Input Validation failed: Please Check the Input");
                                }

                            }
                        } catch (Exception e) {
                            throw new Exception(e);
                        }
                    }
                    break;
                }

                case 1:// File input/output
                {

                    File inputFile = new File(args[0]);
                    try
                    {
                        bufferReader = new BufferedReader(new FileReader(inputFile));
                        int lineNo = 1;
                        while ((input = bufferReader.readLine()) != null)
                        {
                            input = input.trim();
                            if (validation.validateInput(input.trim()))
                            {
                                try
                                {
                                    parkingHandlerMapping.execute(input.trim());
                                }
                                catch (Exception e)
                                {
                                    System.out.println(e.getMessage());
                                }
                            }
                            else
                                System.out.println("Invalid Command " + lineNo + " ,Input: " + input);
                            lineNo++;
                        }
                    } catch (Exception e)
                    {
                        throw new ParkingException(ErrorCode.INVALID_FILE.getMessage(), e);
                    }


                }


                default:
                    System.out.println("Invalid Command. Use following Command: java -jar <jar_file_path> <input_file_path>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            try {
                if (bufferReader != null)
                    bufferReader.close();
            } catch (IOException e) {
            }
        }
    }

    private static void printUsage() {
        StringBuffer buffer = new StringBuffer();

        buffer = buffer.append("A) Create parking lot of size n                : create_parking_lot {capacity}")
                .append("\n");
        buffer = buffer
                .append("B) Park a car                                  : park {car_number} {colour}")
                .append("\n");
        buffer = buffer
                .append("C) Remove(Unpark) car from                     : leave {car_number} {hours}")
                .append("\n");
        buffer = buffer
                .append("D) Print status of parking slot                : status").append("\n");
        buffer = buffer
                .append("E) To Exit                                     : end").append("\n");
        System.out.println(buffer.toString());
    }


}
