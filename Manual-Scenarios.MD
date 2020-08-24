
## Scenarios  1 :
  
### Validate  Send gift card to myself method, check if the payment is processed and Email is sent to correct user.

**Precondition** - Access to  [Demo salon page](https://gift-cards.phorest.com/salons/demo-us#)

**Steps**:

 1. Open the given link.
 2. Click to select amount (Eg:50)
 3. Add valid data in the following fields :
	- Your Email Address
	- Add First Name
	- Add Last Name
 4. Check Selected amount in (Step 2) is displayed in Total Cost.
 5. Click on Checkout
 6. Check the Enter Details are correct
 7. Click on Confirm Details Button
 8. Check the Data on Summary Page
 9. Validate Payment Method Page is open
 10. Add valid data in the following fields :
		- Cardholder Name
		- Zipcode
		- Card Number
		- Expiry
		- Security Code
 11. Click on Submit Button
 12. Ensure the message displayed on the confirmation page ”Payment is accepted, Thank you”
 13. Ensure unique Gift card code is generated
 14. Ensure Confirmation Mail is sent to given Email address

**Expected Result** :

 - Given Link is accessible
 - Data is entered in all the fields on Summary Page
 - Payment Method page is open
 - The Card Details are enter correctly, unique Gift Card Code is generate.
 - Confirmation mail is sent to enter Email address

## Scenarios  2:

### Validate Send gift card to Someone else method, check if the payment is processed and Email is sent to correct user.


**Precondition** - Access to  [Demo salon page](https://gift-cards.phorest.com/salons/demo-us#)

**Steps**
 1. Open the given link.
 2. Click to select amount (Eg:50)
 3. Add valid data in the following fields :
	- Your Email Address
	- Add First Name
	- Add Last Name
	- Add Recipient Email
	- Add Message for Recipient(Optional)
 4. Validate Selected amount in (Step 2) is displayed in Total Cost.
 5. Click on Checkout
 6. Check the Entered Details are correct
 7. Click on Confirm Details Button
 8. Check the Data on Summary Page
 9. Validate Payment Method Page is open
 10. Add valid data in the following fields :
		- Cardholder Name
		- Zipcode
		- Card Number
		- Expiry
		- Security Code
 11. Click on Submit Button
 12. Ensure the message displayed on the confirmation page ”Payment is accepted, Thank you”
 13. Ensure unique Gift card code is generated
 14. Ensure Confirmation Mail is sent to given Email address
 15. Ensure the Gift Voucher Mail is sent to Recipient Email address

**Expected Result** :

 - Given Link is accessible
 - Data is entered in all the fields on Summary Page
 - Payment Method page is open
 - The Card Details are enter correctly, unique Gift Card Code is generate.
 - Confirmation mail is sent to enter Email address as well as to Recipient Email address with valid gift voucher details


## Bugs

 1. On the home page, the input field for First name and Last name  	accepts only digits as input.
 2. Similarly on the payment page, the Card holder name accepts digits.
 3. The validation for the email field approves the use of incomplete email address.
 4. The confirmation email sent to the user has confusing date format. In payment receipt the transaction date is in the format of MM-DD-YY.
 5. But if the similarly applies for the gift voucher validity, 12/22/03. This implies the voucher was valid till 2003.
 6. On send voucher to someone page, in the message field the validation error for max characters is not user friendly, `translation missing: en-US.REGULAR.checkout.message.error.maxCharacter`

