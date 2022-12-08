# BookMyShow
This is Clone of Book My Show BackEnd.

<b>There are following 5 Controllers </b>

- Movie Conttroller
  - AddMovie -> /movie/add
  - {
      "name": "string",
      "releaseDate": "string"
    }
  - DeleteMovieById -> /movie/delete/{id}
  - GetMovieByID -> /movie/get/{id}

- Show Controller
  - AddShow -> /show/add
  - {
      "movieResponseDto": {
        "id": 0,
        "name": "string",
        "releaseDate": "string",
        "showDtoList": [
          null
        ]
      },
      "showDate": "string",
      "showTime": {
        "hour": 0,
        "minute": 0,
        "nano": 0,
        "second": 0
      },
      "theaterResponseDto": {
        "address": "string",
        "city": "string",
        "id": 0,
        "name": "string",
        "theaterType": "SINGLE"
      }
    }
  - DeleteShowByID -> /show/delete/{id}
  - GetShowBYID -> /show/get/{id}

- Theater Controller
  - AddTheater -> /theater/add
  - {
      "address": "string",
      "city": "string",
      "name": "string"
    } 
  - GetTeaterBYID -> /theater/get/{id}

- Ticket Controller
  - Add Ticekt -> /ticket/add
  - {
      "requestedSeats": [
        "string"
      ],
      "seatType": "CLASSIC",
      "showId": 0,
      "userId": 0
    }
  - GetTicektBYID -> /ticekt/get/{id}

- User Controller
  - AddUser -> /user/add
  - {
      "mobNo": "string",
      "name": "string"
    }
  - GetUserByID -> /user/get/{id}


