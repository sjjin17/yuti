import { useState, useEffect } from 'react';
import styled from '@emotion/styled';
import SearchTemplate from '../template/SearchTemplate';

const Container = styled.div`
  display: flex;
  align-items: center;
`;

const tempYoutubers = [
  { Thumbnail: 'images/firstRank.png', name: '1번', subscribers: '1' },
  { Thumbnail: 'images/secondRank.png', name: '2번', subscribers: '2' },
  { Thumbnail: 'images/thirdRank.png', name: '3번', subscribers: '3' },
  { Thumbnail: 'images/thirdRank.png', name: '4번', subscribers: '4' },
  { Thumbnail: 'images/thirdRank.png', name: '3번', subscribers: '3' },
  { Thumbnail: 'images/thirdRank.png', name: '3번', subscribers: '3' },
  { Thumbnail: 'images/thirdRank.png', name: '3번', subscribers: '3' },
];

export default function Search() {
  const [hoverState, setHoverState] = useState(false);
  const [searchInput, setSearchInput] = useState('');
  const [buttonText, setButtonText] = useState('건너뛰기');
  const [selectedList, setSelectedList] = useState([]);

  function addThumbnail(thumbnail) {
    setSelectedList(prev => {
      return [...prev, thumbnail];
    });
  }

  function handleHover() {
    setHoverState(!hoverState);
  }

  useEffect(() => {
    hoverState ? setButtonText('도와주세요') : setButtonText('건너뛰기');
  }, [hoverState]);

  return (
    <>
      <Container>
        <SearchTemplate
          hoverState={hoverState}
          handleHover={handleHover}
          buttonText={buttonText}
          searchInput={searchInput}
          setSearchInput={setSearchInput}
          previewList={tempYoutubers}
          selectedList={selectedList}
          addThumbnail={addThumbnail}
        ></SearchTemplate>
      </Container>
    </>
  );
}
