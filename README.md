# Scratchcard API Reference
Proposed references for Scratchcard API

## Scratchcard Purchase
Open: `POST`

POST api/purchase

Returns number of purchases a player has made.

#### Example response
Player has bought **one** scratchcard:
```
{
    "message": "scratchcard has been purchased",
    "number_of_purchases": 1
}
```

## Game Result
Open: `GET`

GET api/result

#### Example response
Player has won:
```
{
    "message": "player has won",
    "win_amount": 5.00
}
```

Player hasn't won:
```
{
    "message": "player hasn't won",
    "win_amount": 0.00
}
```