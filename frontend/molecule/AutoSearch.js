import React from 'react';
import styled from '@emotion/styled';
import AutoSearchData from './AutoSearchData';

const AutoSearchContainer = styled.div`
  z-index: 3;
  width: 100%;
  height: 50vh;
  background-color: #fff;
  border: 2px solid;
  margin-top: 2.5%;
  margin-bottom: 5%;
  display: flex;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
  flex-wrap: wrap;
  overflow-y: scroll;
=======
>>>>>>> 3aca908 ([FEATURE] 검색 시 미리보기)
=======
  flex-wrap: wrap;
  overflow-y: scroll;
>>>>>>> 668f46b ([TEST] ImageUrl 선택 시 미출력)
=======
  flex-wrap: wrap;
  overflow-y: scroll;
>>>>>>> 8eab706d354fc18f6e5158befb871a602f13c642
`;

const AutoSearchWrap = styled.ul`
  height: 80%;
  display: flex;
  flex-wrap: wrap;
  flex-direction: row;
  position: relative;
`;

export default function AutoSearch({ previewList, addThumbnail }) {
  return (
    <AutoSearchContainer>
      <AutoSearchWrap>
        {previewList.map((youtuber, idx) => (
          <AutoSearchData
            key={idx}
            youtuber={youtuber}
            addThumbnail={addThumbnail}
          ></AutoSearchData>
        ))}
      </AutoSearchWrap>
    </AutoSearchContainer>
  );
}
