import './App.css'
import React,{useState,useEffect, useRef} from 'react'

function App() {

  let [count, setCount] = useState(0);
  const [timer, setTimer] = useState(0);
  const [lap, setLap] = useState([]);
  const [isPaused, setIsPaused] = useState(true);
  const [isHold,setIsHold]=useState(false);
  const holdRef=useRef(null);
  const timerRef=useRef(null);

  const increment = () => {
    if(count >= 10) {
      alert("Count cannot exceed 10");
      return;
    }
    setCount(count= count + 1);
  }
  const decrement = () => {
    if(count <= 0) {
      alert("Count cannot be less than 0");
      return;
    }
    setCount(count= count - 1);
  }
  const reset = () => setCount(0);

  useEffect(()=>{
    if(!isPaused){
      console.log("in useState");
      timerRef.current=setInterval(()=>{
        setTimer(timer=>timer+1);
      },1000)
    }else if(timerRef.current){
      clearInterval(timerRef.current);
    }

    if(isHold){
      console.log("in the isHold")
      holdRef.current=setInterval(()=>{
        setCount(count=>count+1);
      })
    }else if(holdRef.current){
      clearInterval(holdRef.current);
    }
  },[isPaused,isHold])

  const startTimer=()=>{
    console.log("isPaused from start");
    setIsPaused(isPaused=>isPaused=false);
  }
  const handlePause =()=>{
    console.log("ispaused from pause");
    setIsPaused(isPaused=>isPaused=true);
  }
  
  const incrementContinuew=()=>{
    setCount(prevCount=>prevCount+1);
  }

  const handleHoldStart=()=>{
    setIsHold(true);
  }
  const handleHoldStop=()=>{
    setIsHold(false);
  }


  return (
   <>
      <h1>New react APP</h1>
      <div className="container">
          <h2>Count: {count}</h2>
            <div className="functionalButtons">
              <button    
              onMouseDown={handleHoldStart}
              onMouseUp={handleHoldStop}
              onMouseLeave={handleHoldStop}>hold</button>
              <button onClick={increment}>Increment</button>
              <button onClick={decrement}>Decrement</button>
              <button onClick={reset}>Reset</button>
            </div>
          <p>Click the buttons to change the count.</p>
          <p>Count is managed using React's useState hook.</p>
      </div>
      <div className="container">
        <h2>
          Timer: {timer} seconds
        </h2>
        <div className="functionalButtones">
          <button onClick={startTimer}>Start Timer</button>
          <button onClick={() => setTimer(0)}>Reset Timer</button>
          <button onClick={() => setLap([...lap, timer])}>Lap</button>
          <button onClick={() => setLap([])}>Clear Laps</button>
          <button onClick={handlePause}>Pause</button>
        </div>
        <p>
          {lap.length > 0 ? "Laps: " + lap.join(", ") : "No laps recorded yet."}
        </p>
      </div>
   </>
  )
}

export default App
