# NewYorkTime Assignment
The NewYorkTime application will have the following activities.

# Splash
It contains only a simple new york time icon and after some seconds the NewsList Activity will appear.

# News List -
When the user lands on the NewsList activity,
a request is sent to the server along with the
NewYorkTime API Key ,  and the response is shown 
in the recycler view (which has news list). 
The NewsList activity has a toolbar which has the drawer icon , search icon and option menu icon.
if the user had selected item from the recyclerView , it will go on the detail activity.

# Detail Activity -
As the name suggests, this activity is launched when the user clicks on any news list item
when the user comes to detail activity , the parcelable data object is recieve by the getIntent.
and the detail of the news will be appear along with image and this image will be collapseable with toolbar. 

<img src="https://im.ezgif.com/tmp/ezgif-1-1a18413ef43b.gif" />

# How to run the code
1 - clone the link it will be given on the repository   <br />
2 - Or download the project and import project in android studio


# Mockito Framework
Enough about the great features of the app. 
Let’s dive into the test cases written for NewsList activity.
In news list activity we are using liveData , ViewModel Combinations.
In ViewModel class we are going to test the repository class methods like network call to the server

Just goto the Repository class find method of loadNewsData <br />
1 - Right click on the method find the goto from the drop down menu and click test 
 
<a href="https://ibb.co/dgh1bGb"><img src="https://i.ibb.co/16Shs8s/Screen-Shot-2019-12-16-at-3-16-43-PM.png" alt="Screen-Shot-2019-12-16-at-3-16-43-PM" border="0" /></a>

2 - Click on Test and create new test class or use existing one, like i created already below

<a href="https://ibb.co/xgbxN63"><img src="https://i.ibb.co/M1HFm79/Screen-Shot-2019-12-16-at-3-29-35-PM.png" alt="Screen-Shot-2019-12-16-at-3-29-35-PM" border="0"></a>

3 - So the following method will be generated and @Before and @Test so we will write over test on @Test Method.
@RunWith(MockitoJUnitRunner.class) will be used to load all the notation classes which the mockito frame work has and 
@Mock i declared to test the speciy class of the project 

<a href="https://ibb.co/BVXJfBV"><img src="https://i.ibb.co/QF2VJMF/Screen-Shot-2019-12-16-at-3-37-45-PM.png" alt="Screen-Shot-2019-12-16-at-3-37-45-PM" border="0"></a>

4 - So i wrote some test for network call using retrofit so just want to know everything is working fine , and when the network call is successfull  i am returning the some manual data

<a href="https://ibb.co/DMfPMXT"><img src="https://i.ibb.co/rp2KpPN/Screen-Shot-2019-12-16-at-3-56-48-PM.png" alt="Screen-Shot-2019-12-16-at-3-56-48-PM" border="0"></a>

# How to run
5 - After writing the test ,click on left side test icon and click on run as shown below

<a href="https://ibb.co/Xs5JLcT"><img src="https://i.ibb.co/DCMKW0n/Screen-Shot-2019-12-16-at-4-01-47-PM.png" alt="Screen-Shot-2019-12-16-at-4-01-47-PM" border="0"></a>

6 - after passing the test ,it will appear bottom to screen

<a href="https://ibb.co/qj8mcyC"><img src="https://i.ibb.co/LRy9ckr/Screen-Shot-2019-12-16-at-4-07-00-PM.png" alt="Screen-Shot-2019-12-16-at-4-07-00-PM" border="0"></a>

# How to generate code coverage report

1 - Right click on the class of whom you want to generate the code coverage, like below

<a href="https://ibb.co/m5yjHBN"><img src="https://i.ibb.co/KxsP9GK/Screen-Shot-2019-12-16-at-6-48-24-PM.png" alt="Screen-Shot-2019-12-16-at-6-48-24-PM" border="0"></a>

2 -  click on the arrow to generate the code coverage report and you can generate as html file to view in the browser

<a href="https://ibb.co/30d2ZLp"><img src="https://i.ibb.co/SKybC9t/Screen-Shot-2019-12-16-at-6-51-53-PM.png" alt="Screen-Shot-2019-12-16-at-6-51-53-PM" border="0"></a>
