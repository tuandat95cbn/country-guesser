# Country Guesser
This service aim to guess human country by his or her name.
## First Approach - data-based
This approach is powerful when you have association data between country and human name, or possible to collect
data continuously.
### Design and Architecture
![Architecture!](https://github.com/tuandat95cbn/country-guesser/raw/main/arch.png "Architecture")
- Restful service: This service receives requests from clients, check authentication, authorization and find
answers in the elastic search database.
- An elastic search database is used to index the human name and country data.


In detail:

1. Elastic search : Index data\
  `{
  "name": "Nguyen",
  "score": 90.0,
  "country_code":"vn"
  }`
  
2. Restful service Authentication:
    1. Request credentrial : Basic authentication
    1. Authorization : Random token
    1. In memory user detail.


### Implementation
- Restful Service: It is a Spring application using spring boot. Please look at the code base for more concrete
implementation.
- Deployment: Docker and docker-compose.
### Initial Data Source
Take the common name data from [Wiki](https://en.wikipedia.org/wiki/List_of_most_popular_given_names)
### Dicussion
#### Advantage
- This approach is feasible for increasing the accuracy. When we have more data, we can improve data in elastic
search and make it predict better.
- The performance mainly depends on the performance of elastic search, which is easily handled by support
from elastic search itself.
- This approach can be extendable based on support from the elastic search query. Elastic search is completely
flexible, so we can easily create new API or add more filters...
#### Disadvatage
- Performance based on the dataset.
- Have to prepare name the dataset.
#### Furture task
- Aggreate future data.
- Ranking country - Ex. the list of guessed countries is too long - heuristic method???
## Second Approach - rule-based
This approach aims to predict the country by the typical character of the language. This approach is rule-based.
Each language can be recognized by some special character. [Wiki](https://en.wikipedia.org/wiki/Wikipedia:Language_recognition_chart)
### Design and Architecture
### Disscussion
#### Advatage
- Fast - Better performance
- Don’t need prepare data
#### Disadvantage
- Can’t differentiate two countries using the same language. Ex: English was used in the United States and
England.
- the accuracy can’t be improved when having more data.
