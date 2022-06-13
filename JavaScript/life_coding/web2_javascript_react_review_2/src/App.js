import logo from './logo.svg';
import './App.css';


function Header(props) {
  return (
    <div>
      <h1><a href="/" onClick={(event)=>{
        event.preventDefault();
        props.onModeChange();
      }}>{props.title}</a></h1>
    </div>
  )
}

function Nav(props){
  const lis = [];
  for(let i=0; i < props.topics.length; i++){
    let t = props.topics[i];
    lis.push(<li key={t.id}><a href={'/read'+t.id} onClick={(event)=>{
      event.preventDefault();
      props.onModeChange(t.id);
    }}>{t.title}</a></li>);
  }
  return (
    <div>
      <ol>    
        {lis}
      </ol>
    </div>
  )
}

function Article(props){
  return (
    <div>
      <h2>{props.title}</h2>
      {props.body}
    </div>
  )
}


function App() {
  const topics = [
    {id:1, title:'html', body: 'html is...'},
    {id:2, title:'css', body: 'css is...'},
    {id:3, title:'javascript', body: 'javascript is...'}
  ];
  return (
    <div>
      <Header title='WEB' onModeChange={()=>{
        alert('Header');
      }}></Header>
      <Nav topics={topics} onModeChange={(number)=>{
        alert(number);
      }}></Nav>
      <Article title='Welcome' body='Hello, WEB'></Article>
    </div>
  );
}

export default App;
