import logo from './logo.svg';
import './App.css';


function Nav(props) {
  const lis = [
    <li key="1"><a href="/read/1">html</a></li>,
    <li key="2"><a href="/read/2">css</a></li>,
    <li key="3"><a href="/read/3">js</a></li>
  ];
  return <nav>
    <ol>
      {lis}
    </ol>
    </nav>
}

function App() {
  return (
    <div>
      <Nav topics></Nav>
    </div>
  );
}

export default App;
