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

function Create(props){
  return (
    <div>
      <h2>Create</h2>
      <form onSubmit={(event)=>{
        event.preventDefault();
        const title = event.target.title.value;
        const body = event.target.body.value;
        props.onCreate(title, body);
      }}>
        <p><input type="text" name='title' placeholder='title'/></p>
        <p><textarea name="body" placeholder='body'></textarea></p>
        <p><input type='submit' value='Create'/></p>
      </form>
    </div>
  )
}

function Update(props) {
  const [oldTitle, setTitle] = useState(props.title);
  const [oldBody, setBody] = useState(props.body);
  return (
    <div>
      <h2>Update</h2>
      <form onSubmit={(event)=>{
        event.preventDefault();
        const newtitle = event.target.title.value;
        const newbody = event.target.body.value;
        props.onUpdate(newtitle, newbody);
      }}>
        <p><input type="text" name='title' placeholder='title' value={oldTitle} onChange={(event)=>{
          setTitle(event.target.value);
        }}/></p>
        <p><textarea name="body" placeholder='body' value={oldBody} onChange={(event)=>{
          setBody(event.target.value);
        }}></textarea></p>
        <p><input type='submit' value='Update'/></p>
      </form>
    </div>
  )
}

function App() {
  const [mode, setMode] = useState('WELCOME');
  const [id, setId] = useState(null);
  const [topics, setTopics] = useState([
    {id:0, title:'html', body: 'html is...'},
    {id:1, title:'css', body: 'css is...'},
    {id:2, title:'javascript', body: 'javascript is...'}
  ]);
  let content = null;
  let otherContent = null;

  if(mode === 'WELCOME') {
    content = <Article title='Welcome' body='Hello, WEB'></Article>;
  }
  else if (mode === 'READ') {
    content = <Article title={topics[id].title} body={topics[id].body}></Article>;
    otherContent = (
      <>
      <li><a href='' onClick={(event)=>{
        event.preventDefault();
        setMode('UPDATE');
      }}>Update</a></li>
      <li><button onClick={(event)=>{
        setMode('DELETE');
      }}>Delete</button></li>
      </>
    );
  }
  else if (mode === 'CREATE') {
    content = <Create onCreate={(_title, _body)=>{
      const newTopic = {id:topics.length, title:_title, body:_body};
      const newTopics = [...topics];
      newTopics.push(newTopic);
      setTopics(newTopics);
      setId(topics.length);
      setMode('READ');
    }}></Create>
  }
  else if(mode === 'UPDATE') {
    content = <Update title={topics[id].title} body={topics[id].body} onUpdate={(_title, _body)=>{
      const newTopics = [...topics];
      const updatedTopic = {id:topics[id].id, title:_title, body:_body};
      newTopics[id] = updatedTopic;
      setTopics(newTopics);
      setMode('READ');
    }}></Update>
  }
  else if(mode === 'DELETE') {
    const newTopics = [];
    let count = 0;
    for(let i = 0; i < topics.length; i++){
      if(id !== topics[i].id){
        const newTopic = {id:count++, title:topics[i].title, body:topics[i].body };
        newTopics.push(newTopic);
      }
    }
    setTopics(newTopics);
    setMode('WELCOME');
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
      <ul>
        <li><a href='' onClick={(event)=>{
        event.preventDefault();
        setMode('CREATE');
      }}>Create</a></li>
      {otherContent}
      </ul>
    </div>
  );
}

export default App;

// id값 처리를 기존에 배운 것과는 다르게 해줬는데 delete 전까지는 아무 문제가 없었음
// 다만, delete부분 구현을 해주다 보니 나의 방식대로는 문제가 약간 있어서 coount라는 변수를 넣고 만들어줬음
// 게다가 나는 아예 delete라는 모드를 만들어줬는데 사실 없어도 되는 거지만 굳이 문제가 될 정도로는 안 보여서
// 그냥 이번에는 이렇게 만들었음
// 전반적으로 코드수는 줄일 수 있었고 코드 자체도 조금 더 깔끔해져서 가독성이 높아졌다고 생각함