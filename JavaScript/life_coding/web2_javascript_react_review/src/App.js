import { useState } from 'react';
import './App.css';

function Header(props) {
  const current = props.title;
  return (    
    <h1><a href="/" onClick={(event)=>{
      event.preventDefault();
      props.onChangeMode();
    }}>{current}</a></h1>
  )
}

function Nav(props) {
  const lis = [];  
  for(let i = 0; i < props.topics.length; i++) {
    let t = props.topics[i];
    lis.push(<li key={t.id}>
      <a id={t.id} href={'/read/'+t.id} onClick={(event)=>{
        event.preventDefault();
        props.onChangeMode(Number(event.target.id));
      }}>{t.title}</a>
    </li>)
  }
  return (
    <nav>
      <ol>
        {lis}
      </ol>
    </nav>
  )
}

function Article(props) {
  return (
    <div>
      <h2>{props.title}</h2>
      {props.body}
    </div>
  )
}

function Create(props) {
  return (
    <article>
      <h2>Create</h2>
      <form onSubmit={(event)=>{
        event.preventDefault();
        const title = event.target.title.value;
        const body = event.target.body.value
        props.onCreate(title, body);
      }}>
        <p><input type="text" name="title" placeholder='title'/></p>
        <p><textarea name="body" placeholder='body'></textarea></p>
        <p><input type="submit" value="Create"></input></p>
      </form>
    </article>
  )
}

function Update(props) {
  const [oldTitle, setTitle] = useState(props.title);
  const [oldBody, setBody] = useState(props.body);
  return (
    <article>
      <h2>Update</h2>
      <form onSubmit={(event)=>{
        event.preventDefault();
        const title = event.target.title.value;
        const body = event.target.body.value
        props.onUpdate(title, body);
      }}>
        <p><input type="text" name="title" placeholder='title' value={oldTitle} onChange={(event)=>{
          setTitle(event.target.value);
        }}/></p>
        <p><textarea name="body" placeholder='body' value={oldBody} onChange={(event)=>{
          setBody(event.target.value);
        }}></textarea></p>
        <p><input type="submit" value="Update"></input></p>
      </form>
    </article>
  )
}


function App() {
  const [mode, setMode] = useState('WELCOME');
  const [id, setId] = useState(null);
  const [topics, setTopics] = useState([
    {id:1, title:'html', body: 'html is...'},
    {id:2, title:'css', body: 'css is...'},
    {id:3, title:'javascript', body: 'javascript is...'}
  ]);
  let content = null;
  let otherContent = null;

  if(mode === 'WELCOME') {
    content = <Article title='Welcome' body='Hello, WEB'></Article>
  } 
  else if(mode ==='READ') {
    let title, body = null;
    for(let i = 0; i < topics.length; i++){
      if(topics[i].id === id ) {
        title = topics[i].title;
        body = topics[i].body
      }
    }
    content = <Article title={title} body={body}></Article>
    otherContent = (
      <>
        <li><a href={"/update"+id} onClick={(event)=> {
          event.preventDefault();
          setMode('UPDATE');
        }}>Update</a></li>
        <li><button onClick={()=>{
          setMode('DELETE');
        }}>Delete</button></li>
      </>
    )        
  } 
  else if(mode === 'CREATE') {
    content = <Create onCreate={(_title, _body)=>{
      const newTopic = {id:topics.length+1, title:_title, body:_body};
      const newTopics = [...topics];
      newTopics.push(newTopic);
      setTopics(newTopics);
      setId(topics.length+1);
      setMode('READ');
    }}></Create>
  } 
  else if(mode === 'UPDATE') {
    let thisTitle = topics[id-1].title;
    let thisBody = topics[id-1].body;
    content = <Update title={thisTitle} body={thisBody} onUpdate={(_title, _body)=>{
      const updatedTopic = {id:id, title:_title, body:_body};
      const newTopics = [...topics];
      newTopics[id-1] = updatedTopic;
      setTopics(newTopics);
      setMode('READ');
    }}></Update>
  }
  else if(mode === 'DELETE'){
    const newTopics = [];
    for(let i=0; i<topics.length; i++){
      if(id !== topics[i].id){
        newTopics.push(topics[i]);
      }
    }
    setTopics(newTopics);
    setMode('WELCOME');
  }

  return (
    <div>
      <Header title="WEB" onChangeMode={()=>{
        setMode("WELCOME");
      }}></Header>
      <Nav topics={topics} onChangeMode={(_id)=>{
        setId(_id);
        setMode("READ");
      }}></Nav>
      {content}
      <ul>
        <li><a href="/create" onClick={(event)=> {
          event.preventDefault();
          setMode('CREATE');
        }}>Create</a></li>
        {otherContent}
      </ul>
    </div>
  );
}

export default App;
