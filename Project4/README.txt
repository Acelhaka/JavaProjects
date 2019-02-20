README 

Amarilda Celhaka
Project #4
10/29/2018

In this readme file I will try to explain briefly, what may be different
in my program from what was indicated. 
 
Intead of the whole program terminating when one of the dogs 
loyalty = 0, I decided to simply remove that human with the 
dogs from the list. 
Eg:  If there are 4 human, 
if the human 2 dog loyalty = 0; I remove this dog from the list,
and decrease the number of humans. So now there are 3 humans left. 
User can continue to play as long he wants to and as long 
as there is a human to play with
 so human.size() > 0 
If there will be 0 humans left, program will terminate automatically.

Also, on the passTheTime() method, I decided to increase dog hunger by 10%.
Since the dog can get hungry after a while. Also, this will make the dog
loyalty decrease quicker, if a human does not take good care. 

Any time one of the data fields, like hunger, cleanliness, fun goes beyond 
100, it will be set to the max value of 100, and the same thing if it 
passes 0, it will be set to the min value, 0.

Every other method, works as indicated on the project description.
