# Problem 2: Elevator

Implement an Elevator using the SCAN method.

In the SCAN method, an elevator continuously moves in one direction (up or down) until all requests in that direction are served.
Make sure that your code writes a log when the elevator reaches a floor.

## Additional clarifications on the problem

The elevator should be defined with integer max floor, min floor and a start position. Remember, elevators also works with negative numbers.

A request is defined by the user’s current floor (source) and selected floor (target). A request is served by stopping in both source and target EXCLUSIVELY on the direction of the request.

For example, for 

```python
elevator = Elevator (min_floor = 0, max_floor = 5, start_floor = 2)
```

The following requests:

```python
elevator.request_floor (source_floor = 3, target_floor = 0)
elevator.request_floor (source_floor = 1, target_floor = 5)
elevator.request_floor (source_floor = 10, target_floor = 3)

elevator.run()
```

Could have a valid solution similar to this:
```
Request added: From Floor 3 to Floor 0 (Current Floor: 2)
Request added: From Floor 1 to Floor 5 (Current Floor: 2)
Request Rejected: Floor is out of bounds.

Moving from Floor 2 to Floor 1
Arrived at Floor 1
Moving from Floor 1 to Floor 5
Arrived at Floor 5
Moving from Floor 5 to Floor 3
Arrived at Floor 3
Moving from Floor 3 to Floor 0
Arrived at Floor 0
```

When the elevator goes in the opposite direction of a request, the elevator must not do a “pickup”.

The elevator accepts ALL the requests BEFORE it starts running, but it should clean up the pending
requests after handling so the class could be reused by adding more requests.

Once the elevator handles all the pending requests, the method exits.
