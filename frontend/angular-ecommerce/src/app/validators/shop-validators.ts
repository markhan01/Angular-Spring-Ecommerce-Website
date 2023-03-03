import { FormControl, ValidationErrors } from "@angular/forms";

export class ShopValidators {

    // whitespace validation
    static notOnlyWhitespace(control: FormControl) : ValidationErrors {

        // check if string only contains whitespace
        if ((control.value != null) && (control.value.trim().length <= 1)) {

            // invalid, return error object
            // returns error key and value
            return { 'notOnlyWhitespace': true };
        } else {

            // valid string, return null
            return null;
        }

        return null;
    }
}
