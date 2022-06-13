import {useState} from 'react';


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
  const [mode, setMode] = useState('WELCOME');
  const [id, setId] = useState(null);
  const topics = [
    {id:0, title:'html', body: 'html is...'},
    {id:1, title:'css', body: 'css is...'},
    {id:2, title:'javascript', body: 'javascript is...'}
  ];
  let content = null;

  if(mode === 'WELCOME') {
    content = <Article title='Welcome' body='Hello, WEB'></Article>;
  }
  else if (mode === 'READ') {
    content = <Article title={topics[id].title} body={topics[id].body}></Article>;
  }


  return (
    <div>
      <Header title='WEB' onModeChange={()=>{
        setMode('WELCOME');
      }}></Header>
      <Nav topics={topics} onModeChange={(_id)=>{
        setId(_id);
        setMode('READ');
      }}></Nav>
      {content}
    </div>
  );
}

export default App;
