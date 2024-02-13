# Inventory Web App

>C.  Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.
> 
Modified all template .html files.  Added Bootstrap CSS and demo.css link to each header.  Modified demo.css to change background color and font.    Added Bootstrap Grid layout to mainscreen.html. Altered Bootstrap display attributes for buttons and tables in mainscreen.html.  Changed store Title and Header.  

> D.  Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.
> 
Added new MVC mapping in MainScreenControllerr.java on line 56.  Created new template about.html with return to home page link on line 24.  Modified mainscreen.html to add link to about page on line 21.

> E.  Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.
> 
Modified BootStrapData.java lines 43-105.  First retrieved part and product repository count and assigned to their respective  variables.  Before adding parts, checked to make sure partCount and productCount are both equal to 0 indicating empty repositories.  If repositories are empty, loaded 5 parts and 5 products.

> F.  Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:
>- The “Buy Now” button must be next to the buttons that update and delete products.
>- The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.
>-  Display a message that indicates the success or failure of a purchase.
> 
Modified mainscreen.html(Lines 91-95) to add Buy Now button as a form input with post method. Created DecProductController.java with PostMapping annotation on method submitPurchaseForm to check inventory and either display error page or call decreaseInvById function.  Added decreaseInvById function to ProductService.java(Line 20) and implemented new method in ProductServiceImpl.java(Lines 71-79)  

>G.  Modify the parts to track maximum and minimum inventory by doing the following:
>- Add additional fields to the part entity for maximum and minimum inventory.
>- Modify the sample inventory to include the maximum and minimum fields.
>- Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.
>- Rename the file the persistent storage is saved to.
>- Modify the code to enforce that the inventory is between or at the minimum and maximum value.
>
Modified Part.java(Lines 35-37, Lines 101-113) to add invMin and invMax variables plus getters and setters.  Added ValidInv annotation for class(Line 20).  Modified BootStrapData for all parts to call setters for min and max inventory.  Modified InHousePartForm.html and OutsourcedPartForm.html to add form input for max and min inventory values.  Changed database file name in application.properties to "spring-boot-h2-dbNewName1" on line 6.  Created custom validator files ValidInv.java and InvValidator.java to retrieve min and max inventory values and compare entered inventory value to make sure it is between the max and min.
>H.  Add validation for between or at the maximum and minimum fields. The validation must include the following:
>- Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.
>- Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.
>- Display error messages when adding and updating parts if the inventory is greater than the maximum.
>
Modified invValidator.java(Lines 19-37) to output custom validation error messages based on either being above the maxInv or below the minInv.  Modified EnufPartsValidator.java(Line 37-39) to adjust logic to check to ensure the inventory of the part that is being added will remain at or above the minimum inventory value after building product.  Modified ValidEnufParts.java(Line 20) to customize message based on current logic.
>I.  Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.
> 
Modified PartTest.java(Lines 104-120) adding 2 unit tests to test functionality of setMaxInv and setMinInv functions.
>J.  Remove the class files for any unused validators in order to clean your code.
> 
Deleted DeletePartValidator.java and ValidDeletePart.java as it was unused.