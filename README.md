General Description
	Our proposed IOU program is an innovative application designed to offer a comprehensive solution for managing debts and payments. The app is built to streamline and organize the debt-tracking process, providing users with an easy-to-use platform to manage their IOUs efficiently.
With our IOU program, users can quickly create IOUs for any kind of transaction, whether it's borrowing money from a friend or splitting a bill with a group. The app is designed to be flexible and customizable, allowing users to add details like payment schedules, payment methods, and payment reminders.
One of the key features of our IOU program is the ability to set reminders for upcoming payments. Users can easily schedule payment reminders for their upcoming debts, ensuring that they never miss a payment deadline. The app also allows users to view their outstanding debts and credits, providing them with an at-a-glance overview of their financial situation.
Furthermore, the IOU app provides users with the ability to send reminders to friends who owe them money. This feature helps users to avoid awkward conversations and keeps them on top of their financial situation. The app's user-friendly interface and intuitive design make it easy for anyone to use, regardless of their level of technical expertise.
Our IOU program is a must-have app for anyone looking to simplify their financial transactions and stay on top of their debts. Its comprehensive features, flexible customization, and user-friendly interface make it the ideal solution for managing debts and payments in a streamlined and organized way.
Specific Description, Details, Features
The IOU app allows for people to connect with each other by logging their debts to one another. It is oriented towards making payment requests and logs as simple as possible, a feature currently unparalleled by major virtual payment apps.
The app opens with a dashboard that presents all the money the user owes people, with names and the total amount for each. At the top of the dashboard shows a large text that represents the ‘net influx’ of the user, showing after all IOUs, what the final income is. Below this, the application starts with a compiled list of debts, stacking debts for the same person, but has the ability to open a ‘raw’ log that stores time, reason for payment, and individual payment amounts. The compiled payments feature our debt-reduction algorithm, in which debts to each other can be neutralized and added to remove redundancy. The top of the dashboard displays the sum of all debts that you owe. On another page is the outstanding payments, which has the same functionality of displaying a compiled list, with the option of a more detailed ‘raw’ list of debts other people have for you. On the third page of the app exists the user’s private payment logs, in which you can see all confirmed transactions you have made or received. This only appears as a raw list, with every transaction stored with names, reasons, amounts, etc. The IOU app will feature an account system, complete with unique usernames and passwords. This project will allow for the user to log in and out as any user, and create accounts too. with the login of each user, the program can privately display all the debts and requests of a user for their dashboard.
The debt-simplification process is going to require its own class, able to interpret the users list of outgoing payments and requests. Each user has an assigned list of ‘transaction’ objects. We will iteratively traverse the list to find repeat requests, in which requests can then stack. If 2 transactions oppose one another, where a payment and request go toward 2 users, it can reduce, creating the net amount of the two as 1 or 0 objects. with each new transaction object, they are being put into a new, compiled list, that the GUI can then access and display for the front-end. This is done to ensure that both compiled and raw forms exist, so that the user can toggle between the two states they want to see.
For our data factory, we will import a CSV file that contains users, preset debts and passwords. When logging into an account, the program will be able to find all outstanding payments from other accounts, with each payment as a custom data type that can store all required information. As stated earlier, each payment object will store date, time, reason, amount, user, and directed user for payment.
At the bottom of the page the application will have 2 buttons: pay and request. These buttons direct the user to enter all required information to create a new payment object, that can then be displayed either on the user’s dashboard or the directed user’s page, depending on whether it was defined as a payment or request. Depending on the payment being classified as a pay or request, it needs to appropriately display in the dashboard or “what others owe you” page. An additional feature is that you can create personal transaction targets, or track transactions with people that do not have accounts. This is an effective feature that would allow for more personalized benefits, where you can now keep track of payments with friends, even if they do not have an account for the app. This feature is completely unseen in modern online payment applications, and would greatly benefit to track payments with an increased audience.
The program will require a CSV interpretation class, that is able to build our data structures that stores all required payment information and usernames. The application will also utilize a modified graphic panel to create a minimal and intuitive design. The CSV exists to effectively store a ‘preload’ set of data, creating preexisting users and payments that can then be processed through the data factory. Tracking IOUs has never been made easier, and we believe that this project will serve as a functional application for anyone.
Target Audience
 The IOU intended market is very large, we are targeting consumers of ages 16 and older. This app is intended for those that find themselves typically having to pay others and forgetting to pay off friends, family, colleagues, and peers. The app also serves as an alternative to complicated existing payment apps that cannot track missed payments if other people do not own the app. With our app, you could write requests to someone that does not have an account, immensely increasing app capability and functionality. This function exists for friends that are lazy enough to miss payments, and not set up an IOU account. Now you can track how much your lazy friends owe you, and can show them all the debts they have for you. The IOU app offers a new way to track your money, and ensure that people owe the right amount to anyone.
Purpose
This program is designed for a person to track money that other people owe them, and to track debt that you owe to friends, family, and business colleagues. This app is good for tracking your money flow from person to person.
Design Approach
We intend to use the chaos workflow, as it allows for rapid development to put out and test the highest priority components of the project. We will work on the most important components first, and then add on features if we have more time. We want to be able to complete the project in a quick time frame, and are not very component oriented as the GUI pages are going to be very interdependent and rely on common data sets. We will be able to test the reliability and versatility of our debt-reduction algorithm, and will rely on repeated testing to ensure a quality final product.
Data Structures and Organization
Class Structure:
Main class: contains the main method and handles the user interface.
User class: contains methods for creating, retrieving, and updating user information.
Debt class: contains methods for creating, retrieving, and updating debt information.
CSVHandler class: contains methods for reading and writing CSV files.
Debt Simplification class: contains methods for simplifying debts.
Login class: will check the username and password that user put in the input box and compare with all login data from CSV login file
Data Structure:
User: stores information about each user, including their username and password.
Debt: stores information about each debt, including the debtor, the creditor, the amount owed, and any comments.
Logs: stores information about each payment, including 2 users(from and to who), amount, date, and reason/comment.
Data Classes:
User class - a class to store user information such as name, username, and password.
Payment class - a class to store information about each payment, including date, time, reason, amount, user, and directed user for payment.
Transaction class - a class to store information about each transaction, including time, reason, and individual payment amounts.
Dashboard class - a class to display all the money the user owes people, with names and the total amount for each.
DebtReduction class - a class to interpret the user's list of outgoing payments and requests and simplify debt.
OutstandingPayments class - a class to display a compiled list of debts other people have for the user.
PrivatePaymentLogs class - a class to store and display all confirmed transactions the user has made or received.
CSVInterpretation class - a class to build data structures that store all required payment information and usernames from a CSV file.
GraphicPanel class - a class to create a minimal and intuitive design.
PersonalTransactionTargets class - a class to create personal transaction targets or tracking transactions with people that do not have accounts.
GUI
Include a graphic of what your GUI might look like.  If you like, you can open NetBeans and create a prototype.  You can also use Photoshop, Power Point, etc.

Things to Figure Out and Research
How to build diagrams in NetBeans
Debt Simplification method
username system
GUI outside of NetBeans default
API in general
how to store pre-build data (CSV probably)
Payment confirmation from account to account


Potential Features
push notifications to remind someone to pay you
Time Skip, being able to create transactions and requests for set times
login and password system
ability to login as another user (Account system)
Balance + adding and subtracting virtual money
Group up debts (Everyone from a party need to pay you $10)
Themes?
Color usernames compared with other users(if someone owe you 5, his name is green, and if another person owe you 100, his name is red)
Game of checkers for a chance to be forgiven for your debt
ability to create an account
Anti-scam structure(request)
Programming Tasks
DataFactory for your debt
DataFactory for someone’s debt
logs from CSV data
stats from CSV data
Confirmation of adding $ to your debt account
How to implement simplification method(Automatic or manual)
Manipulate CSV data to create diagrams and stats
3 different tabs (What you owe, what other people owe you, and logs)
Summary Dashboard(What you owe to other people + Balance)
sort my debt amount
comments on each debt
conversion from compiled to raw data and back (if 1 user has 2 debts)
sum of your debt on the dashboard
Pay/Request button 
Popup window for pay/request
