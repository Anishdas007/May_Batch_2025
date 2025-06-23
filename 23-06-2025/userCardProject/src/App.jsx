import { useEffect, useState } from 'react'
import './App.css'
import Card from './components/CardCompoent'

function App() {
  const [users,setUsers]=useState([]);

  useEffect(()=>{
    fetchUser();
  },[])
  

  const fetchUser=async()=>{
    const getUser= await fetch('https://dummyjson.com/users');
    const user=await getUser.json();
    setUsers(users=>users=user.users);
  }

  return (
    <div style={{ display: 'flex', flexWrap: 'wrap' }}>
      {users.map(user => (
        <Card
          key={user.id}
          title={`${user.firstName} ${user.lastName}`}
          subtitle={user.email}
          image={user.image}
        >
          <p>Age: {user.age}</p>
          <p>Gender: {user.gender}</p>
        </Card>
      ))}
    </div>
  )
}

export default App
