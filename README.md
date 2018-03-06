# OOPLabs2
![badge-jdk-8]
[![Build Status][ci-travis]](https://travis-ci.org/ZulusK/OOPLabs2)
[![codecov][ci-codecov]](https://codecov.io/gh/ZulusK/OOPLabs2)
![junit5-gradle-consumer][badge-junit-jupiter]


The repository stores the source code of laboratory works of `Object-oriented programing, second term`    
> Teacher: Zabolotnaya Tatiana Nikolaevna KPI, FAM 2018    
> Student: Kazimirov Danil, group KP-61
### Technologies
* Java
* Maven


### Lab1
1. Use the Bridge template to create
program calculator, which works in 2 modes: the usual calculator
(provides support for 4 basic mathematical operations: adding,
subtraction, multiplication, division) and engineer calculator (provides
support of 4 basic mathematical operations, as well as mining
square root, computation of the remainder from division, elevation of the number to
a given degree).
2. Using the design template to implement the mechanism
selling cosmetics through a network of distributors (network marketing).
Everyone can be either the ultimate seller of cosmetics, or
the manager of a certain number of subordinate sellers, to whom he sells the goods.
Each manager sells cosmetics at a certain percentage more expensive than he
she got it. But to exceed the final retail price of the product,
the distributor has no right established by the company.
### Lab2
1. To develop a module for accounting work software, which will automatically create a package of electronic financial documents (statement of work performed, invoice, etc.), confirming the company's obligations to the customer, only in case of payment of the last service or product.
2. The old system of automatic greetings of users of the site earlier all welcomed the same: "Hi," + a person's name. Now it is decided that in this way the system should welcome only people younger than 35 years old. Users over the age of 35 should see the message "Good afternoon, + Name. Using the design template to ensure the differentiation of the output of the welcome line (transfer to the appropriate method of the entity as a whole, or the values ​​of its fields, the name and age). If the age of the user is unknown, by default, it is more than 35 years old.
### Lab3
1. Playing cards. Using a design template to create a deck of cards. To do this, use the appropriate prototypes of playing cards of each suit. In the created cards change only their rank. List the cards thus obtained on the screen.
2. Organize the production of certificates for laureates of the intercity competition, diplomas for diplomas and certificates for all other participants on the basis of using the template "Abstract Factory". The list of participants in the competition contains the following data: school and class of the student, as well as the place he received (or a note on awarding the competition diploma). All letters created must be independent objects. Polygraphic firms engaged in the production of this type of products, differ in the number of colors used for printing, paper quality and, accordingly, the price of services. Provide in the program the choice of the firm for manufacturing letters, depending on the available amount of money.
### Lab4
1. Using the design template to implement the automatic calculation of discounts for payment for subscriptions in a sports complex. If a person is a client for more than six months, she has a discount of 5% (status
"Regular customer"). If a person issues a monthly subscription to Sports complex regularly (exactly one month from the date of the previous Purchase of a subscription), it has an additional 10% discount (the status of "VIP client").
2. Depending on the amount of time a housewife can spend to clean the apartment, there are 3 variants of cleaning: easy cleaning (fold up scattered things, sweep the floor), usual cleaning (wipe the dust, use a vacuum cleaner) and the general cleaning (wet cleaning of the floor, as well as window cleaning). By using the design template to implement these types of cleaning. 
### Lab5
1. When buying expensive items in the shop, the buyer found that he does not have a sufficient amount of money and he must decide whether to borrow money to pay for a purchase immediately, or take it on credit. He calls his own A friend with a request to borrow the amount that is missing. In case if The other party has the necessary amount and can lend it, the buyer issues buy right away. If a friend does not have the right amount, he can in his own call someone from your friends with a similar request. In case no amount is found, the buyer issues a purchase from credit. Using the design template to simulate the described the situation.
2. For sale / purchase apartments people apply to agencies real estate, where in case of sale the apartment is registered at the base of apartments and help to find a buyer on it, in the case of purchase - register in the base of buyers, fix the wishes of the buyer to the apartment and pick a plurality of apartments that meet these requirements. By help template designing to simulate process sale / purchase of apartments with the participation of direct sellers and buyers, as well as real estate agencies. When selecting offers of apartments Real estate agency can contact for additional information to
other similar agencies.

[badge-jdk-8]: https://img.shields.io/badge/jdk-8-yellow.svg "JDK-8"
[badge-tool-maven]: https://img.shields.io/badge/tool-maven-0440af.svg "Maven wrapper included"
[badge-junit-jupiter]: https://img.shields.io/badge/junit-jupiter-green.svg "JUnit Jupiter Engine"

[ci-codecov]: https://codecov.io/gh/ZulusK/OOPLabs2/branch/master/graph/badge.svg "Code coverage"
[ci-travis]: https://travis-ci.org/ZulusK/OOPLabs2.svg?branch=master "Travis CI build status"