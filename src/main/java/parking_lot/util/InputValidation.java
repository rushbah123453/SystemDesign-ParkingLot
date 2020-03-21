package parking_lot.util;

import parking_lot.constant.Constants;

public class InputValidation {


    public boolean validateInput(String input) {
        String[] inputs = input.split(" ");
        String key = inputs[0];
        int length = inputs.length;
        int actualArgs=length-1;
        boolean valid = true;
        switch (key) {

            case Constants.CREATE_PARKING_LOT:
                if (actualArgs!= Constants.ONE_ARGS)
                    valid = false;
                break;

            case Constants.PARK:
                if (actualArgs!= Constants.TWO_ARGS)
                    valid = false;
                break;

            case Constants.LEAVE:
                if (actualArgs!= Constants.TWO_ARGS)
                    valid = false;
                break;

            case Constants.STATUS:
                if (actualArgs!= Constants.NO_ARGS)
                    valid = false;
                break;

            case Constants.END:
                if (actualArgs != Constants.NO_ARGS)
                    valid = false;
                break;

            default:
                valid = false;
                break;
        }


        return valid;
    }

}
